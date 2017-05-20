package io.inventi.swagger

import groovyx.net.http.RESTClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AggregateController {

  @Autowired
  private Config cfg;

  @GetMapping(value = "/v2/api-docs")
  @ResponseBody
  ResponseEntity<Map> path() {
    return ResponseEntity.ok().body(aggregate(cfg));
  }

  private aggregate(Config cfg){

    def service = new RESTClient(cfg.baseurl)

    def data = [
        swagger: "2.0",
        info: [
            title: cfg.title,
            description: cfg.description,
            version: "1.0",
        ],
        host: "",//TODO define host and base maybe?
        basePath: "",
        tags: [],
        paths: new HashMap(),
        definitions: new HashMap()
    ];

    cfg.apis.each {
      api ->
        def d = service.get(
            path: api,
        ).data

        data.tags += d.tags
        data.paths += d.paths
        data.definitions += d.definitions;
    }

    return data
  }
}
