// SPDX-License-Identifier: MIT
pragma solidity ^0.8.13;

import "@openzeppelin/contracts/token/ERC721/ERC721.sol";
import "@openzeppelin/contracts/token/ERC721/extensions/ERC721Enumerable.sol";
import "@openzeppelin/contracts/token/ERC721/extensions/ERC721URIStorage.sol";
import "@openzeppelin/contracts/access/Ownable.sol";

contract CarpNFT is ERC721,ERC721Enumerable,ERC721URIStorage,Ownable{
    uint256 private _nextTokenId;

    constructor(address owner)
    ERC721("CarpNFT","CARPN") 
    Ownable(owner){

    }

    function safeMint(address to , string memory uri) public onlyOwner{
     uint256 tokenId = _nextTokenId++;
        _safeMint(to,tokenId);
        _setTokenURI(tokenId,uri);
    }


    function _update(address to, uint256 tokenId, address auth)
        internal
        override(ERC721, ERC721Enumerable)
        returns (address)
    {
        // 调用链中的下一个实现，确保所有扩展合约（Enumerable, URIStorage）正确处理
        return super._update(to, tokenId, auth);
    }
    

    
    /**
     * @dev **修复您第一个错误:** 解决 ERC721 和 ERC721Enumerable 的 _increaseBalance 冲突。
     * 注意参数类型为 uint128 (OpenZeppelin V5.0+)。
     * See {ERC721-_increaseBalance}.
     */
    function _increaseBalance(address account, uint128 value)
        internal
        override(ERC721, ERC721Enumerable)
    {
        // 调用链中的下一个实现，确保 ERC721Enumerable 维护其内部结构
        super._increaseBalance(account, value);
    }


    // =========================================================================
    // 必要的重写 (Overrides)
    // 解决 ERC721、ERC721Enumerable 和 ERC721URIStorage 之间的函数冲突
    // =========================================================================

    /**
     * @dev 解决 ERC721 和 ERC721URIStorage 的 tokenURI 冲突。
     * See {IERC721Metadata-tokenURI}.
     */
    function tokenURI(uint256 tokenId)
        public
        view
        override(ERC721, ERC721URIStorage)
        returns (string memory)
    {
        // 调用链中的下一个实现，即 ERC721URIStorage 的实现
        return super.tokenURI(tokenId);
    }


    


  

   
    function supportsInterface(bytes4 interfaceId)
        public
        view
        override(ERC721, ERC721Enumerable, ERC721URIStorage) 
        returns (bool)
    {
        return super.supportsInterface(interfaceId);
    }

 
  

}