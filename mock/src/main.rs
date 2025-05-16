mod model;

mod route;

use actix_web::{web, App, HttpServer, HttpResponse};
use log::__private_api::log;
use log::info;

#[actix_web::main]
async fn main() -> std::io::Result<()> {
    log4rs::init_file("log4rs.yml", Default::default());

    info!("mock server ready");
    HttpServer::new(|| {
        App::new()
            .service(route::metric_routes::health_check)
            .service(route::health_check::health_check)
            .route("/", web::get().to(HttpResponse::Ok))
    })
        .workers(4)
        .bind(("127.0.0.1", 8080))?
        .run()
        .await
}