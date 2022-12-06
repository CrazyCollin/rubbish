use std::io::{BufReader, BufWriter, Write};
use std::net::{TcpStream, ToSocketAddrs};
use serde_json::de::IoRead;
use crate::proto::Request;
use crate::{Response, Result};

pub struct Client{
    writer:BufWriter<TcpStream>,
    reader:serde_json::de::Deserializer<IoRead<BufReader<TcpStream>>>
}

impl Client {
    pub fn new(addr:impl ToSocketAddrs)->Result<Self>{
        let reader=TcpStream::connect(addr).unwrap();
        let writer=reader.try_clone().unwrap();
        Ok(Self{
            writer:BufWriter::new(writer),
            reader:serde_json::de::Deserializer::from_reader(BufReader::new(reader))
        })
    }
    // pub fn send_and_receive(&mut self,request:&Request){
    //     serde_json::to_writer(&mut self.writer,request).unwrap();
    //     self.writer.flush().unwrap();
    //     let s=serde_json::from_reader(self.reader).unwrap();
    //     match Response::deserize { }
    // }
}

#[cfg(test)]
mod tests{

    #[test]
    fn test_serialize(){

    }
}