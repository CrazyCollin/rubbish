use serde::{Deserialize, Serialize};

#[derive(Serialize, Deserialize, Debug)]
pub enum Request {
    /// for set command
    SET(String, String),
    /// for rm command
    REMOVE(String),
    /// for get command
    GET(String),
}

#[derive(Serialize, Deserialize, Debug)]
pub enum Response{
    Ok(Option<String>),
    Err(String)
}