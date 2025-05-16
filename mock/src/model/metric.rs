use std::time::{SystemTime, UNIX_EPOCH};
use serde;

use chrono::prelude::*;

#[derive(serde::Deserialize, Debug, Default)]
pub struct Metric {
    domain: String,
    item_id: String,
    user_id: String,
    time_stamp: Option<u64>
}

impl Metric {
    pub fn set_current_time() -> u64 {
        let current_time = SystemTime::now().duration_since(UNIX_EPOCH)
            .expect("Time went backwards");

        let timestamp = current_time.as_secs() * 1000 +
            current_time.subsec_nanos() as u64 / 1_000_000;

        timestamp
    }
}