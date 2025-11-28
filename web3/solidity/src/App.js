// import logo from './logo.svg';
import './App.css';
import Web3 from 'web3';
import { useState } from 'react';
import ABI from './ABI.json';


function App() {

  const [web3, setWeb3] = useState(null);
  const [address, setAddress] = useState(null);
  const [bankContract, setBankContract] = useState(0);
  const [myDeposit, setMyDeposit] = useState(null);
  const [number, setNumber] = useState('');
  const [to, setTo] = useState(null);
  const newNumber = (e) => {
    setNumber(e.target.value);
  }
  const newAddress = (e) => {
    setTo(e.target.value);
  }

  const getMyDeposit = async () => {
    const deposit = await bankContract.methods.myBalance().call({
      from: address,
    });
    setMyDeposit(deposit+"");
  }

  const deposit = async () => {
    await bankContract.methods.deposit(number).send({
      from: address
    });
  }
  
  const withdraw = async () => {
    await bankContract.methods.withdraw(number).send({
      from: address
    });
  }

  const transfer = async () => {
    await bankContract.methods.transfer(to, number).send({
      from: address,
    });
  }

  const connectWallet = async () => {
    // 1.获取钱包账户
    const accounts = await window.ethereum.request({
      method: 'eth_requestAccounts',
    });
    setAddress(accounts[0]);

    // 2. 连接web3
    const web3 = new Web3(window.web3.currentProvider);
    setWeb3(web3);

    // 3. 获取智能合约 ABI + address 0x0E0E3a61612B6B506EA6B490dCebf9f3bD0fba07
    const bankContract = new web3.eth.Contract(ABI, '0x6d8b83ba756052172973d73ed9a107818c4837bf');
    setBankContract(bankContract);
  }

  return (
    <body className='body' style={{height:'100vh'}}>
    <div className="App bg-img">
      <div className='card'>
        <h1 className='h1'>BANK</h1>
        <button className='button' onClick={connectWallet}>connect wallet</button>
      <h3 className='h3'>账户地址-Address:{address}</h3>

      <section>
        <div>
          <p className='h3'>银行余额:{myDeposit} <button onClick={getMyDeposit}>查询</button> </p>
        </div>
      </section>
      
      <section>
        <div>
        <p className='h3'>金额：<input className='input' onChange={newNumber} type='type'/>
        <button onClick={deposit}>存钱</button></p>
        </div>
      </section>
      <section>
        <div>
        <p className='h3'>金额：<input className='input' onChange={newNumber} type='type'/>
          <button onClick={withdraw}>取钱</button></p>
        </div>
      </section>
      <section>
        <div>
          <p className='p1'>转账地址：<input className='input' onChange={newAddress} type='type'/></p>
          <p className='p2'>转账金额：<input className='input' onChange={newNumber} type='type'/><button onClick={transfer}>转账</button></p>
        </div>
      </section>
      </div>
    </div></body>
  );
}

export default App;