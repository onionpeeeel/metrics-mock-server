use actix_web::{post, web, HttpResponse, Responder};
use log::info;
use crate::model::metric::Metric;

#[post("/metrics")]
pub async fn health_check(metric: web::Json<Metric>) -> impl Responder {
    info!("✅ Metrics Count Completed: ${:?}", metric);;

    HttpResponse::Ok().body("Metric received")
}