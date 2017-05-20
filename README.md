# Swagger json aggregator

Aggregates multiple swagger json into single json file.
Use it to aggregate multiple service APIs into single page.

## Getting started

 * Run `docker-compose up -d`
 * Open http://localhost:8080/?url=http://localhost:8014/v2/api-docs

## Usage

* Put list of aggregated services to application.yml.
Aggregate works with services that are under single host e.g behind gateway.
* Run app.
