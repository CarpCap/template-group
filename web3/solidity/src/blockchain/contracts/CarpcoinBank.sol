// SPDX-License-Identifier: MIT
pragma solidity ^0.8.13;

import "@openzeppelin/contracts/interfaces/IERC20.sol";
import "@openzeppelin/contracts/token/ERC20/utils/SafeERC20.sol";
import "@openzeppelin/contracts/access/Ownable.sol"; // 引入所有权合约

// 您的 Bank 合约现在继承了 Ownable，部署者即为合约所有者
contract Bank is Ownable {
    using SafeERC20 for IERC20; // 引入 SafeERC20 库

    // 钱包
    mapping(address => uint) public deposited;

    // 数字货币 合约地址 (即 CARP 币地址)
    address public immutable token;

    // --- 构造函数 ---
    // 部署者将成为合约所有者，并指定要管理的核心代币地址
    constructor(address _token) {
        token = _token;
        // Ownable 合约的构造函数会将 msg.sender (部署者) 设置为 owner
    }

    // --- 核心业务逻辑 (保持不变) ---

    // 余额 (显示给用户的“存款”余额)
    function myBalance() public view returns (uint balance) {
        balance = deposited[msg.sender] / (10 ** 18);
    }

    // 转入，数字货币 -> 智能合约 (用户存款)
    function deposit(uint amount) public {
        uint amountWei = amount * 10 ** 18;
        // 确保用户已对本合约授权，并将 CARP 币转移到 Bank 合约
        require(IERC20(token).transferFrom(msg.sender, address(this), amountWei), "transfer error");
        deposited[msg.sender] += amountWei;
    }

    // 提取 智能合约 -> 数字货币 (用户提款)
    function withdraw(uint amount) external {
        uint amountWei = amount * 10 ** 18;
        require(amountWei <= deposited[msg.sender], "the amount more then bank of balance");
        
        // 使用 SafeERC20 安全地将 CARP 币转移给提款人
        IERC20(token).safeTransfer(msg.sender, amountWei); 
        deposited[msg.sender] -= amountWei;
    }

    // 转账 (内部记账式转账，不涉及 CARP 币的外部转移)
    function transfer(address to, uint amount) external {
        uint amountWei = amount * 10 ** 18;
        require(amountWei <= deposited[msg.sender], "the amount more then bank of balance");
        deposited[msg.sender] -= amountWei;
        deposited[to] += amountWei;
    }
    
    // --- 代币救援功能 ---
    
    // @dev 仅允许合约所有者调用。用于救援意外发送到合约地址的非核心代币。
    // @param tokenAddress 要救援的代币合约地址 (例如 BAC 币地址)。
    // @param to 接收救援代币的地址。
    // @param amount 救援的数量 (以代币的最小单位计)。
    function rescueTokens(
        address tokenAddress,
        address to,
        uint amount
    ) external onlyOwner { //    onlyOwner确保只有合约部署者可以调用
        // 安全检查 1: 确保救援的代币地址有效
        require(tokenAddress != address(0), "Cannot rescue from zero address");

        // 安全检查 2 (核心防御): 严禁救援核心代币 (CARP 币)! 
        // 确保核心资产的安全，防止所有者恶意或意外地提取用户的存款。
        require(tokenAddress != token, "Cannot rescue the core managed token.");

        // 安全检查 3 (可选): 确保救援的不是 ETH/BNB (如果需要，需要另一个函数来救援原生币)
        // require(tokenAddress != address(this), "Cannot rescue native token with this function.");

        // 执行救援：使用 SafeERC20 安全地将代币转移给接收者
        IERC20(tokenAddress).safeTransfer(to, amount);
    }

    // (注意: 您的原始代码中有一个 requireBalance 的 modifier 和 withdraw2，
    // 为了简洁和安全，我使用了更清晰的 withdraw 函数，并移除了未使用的 modifier。)
}