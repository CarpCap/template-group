// SPDX-License-Identifier: MIT
pragma solidity ^0.8.13;

import "@openzeppelin/contracts/interfaces/IERC20.sol";
import "@openzeppelin/contracts/token/ERC20/utils/SafeERC20.sol";


contract Bank{
    //钱包
    mapping(address => uint) public deposited;

    // 数字货币 合约地址
    address public immutable token;

    modifier requireBalance(uint amount){
        amount = amount * 10 **18;
        require(amount<= deposited[msg.sender],"the amount  more  then bank of balance");
        _;
    }
    

    constructor(address _token){
        token=_token;

    }

    //余额
    function myBalance() public view returns(uint balance){
        balance = deposited[msg.sender]/(10 ** 18);

        // return deposited[msg.sender]/(10 ** 18);
    }


    //转入， 数字货币 -> 智能合约       address(this) 代表当前合约地址
    function deposit(uint amount) public{
        amount = amount * 10 ** 18;
        require(IERC20(token).transferFrom(msg.sender,address(this),amount), "transfer error");
        deposited[msg.sender] += amount;

    }

    //提取 智能合约 -> 数字货币
    function withdraw(uint amount) external {
        amount = amount * 10 **18;
        require(amount<= deposited[msg.sender],"the amount  more  then bank of balance");
        SafeERC20.safeTransfer(IERC20(token),msg.sender,amount);
        deposited[msg.sender] -= amount;
    } 

    //提取 智能合约 -> 数字货币
    function withdraw2(uint amount) external requireBalance(amount){
        amount = amount * 10 **18;
        SafeERC20.safeTransfer(IERC20(token),msg.sender,amount);
        deposited[msg.sender] -= amount;
    } 

    //转账
    function transfer(address to, uint amount) external {
        amount = amount * 10 **18;
        require(amount<= deposited[msg.sender],"the amount  more  then bank of balance");
        deposited[msg.sender] -=amount;
        deposited[to] +=amount;
    }

}