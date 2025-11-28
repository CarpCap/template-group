import ABI from "../ABI.json";

const bank_address = "0x6d8b83ba756052172973d73ed9a107818c4837bf";

const newBankContract = web3 => {
    return new web3.eth.Contract(ABI, bank_address);
};

export default newBankContract;