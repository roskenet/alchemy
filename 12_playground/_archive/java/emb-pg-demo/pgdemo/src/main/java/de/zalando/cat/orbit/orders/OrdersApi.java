package de.zalando.cat.orbit.orders;


import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


public interface OrdersApi {

    @ApiOperation(value = "Insert Orders from CSV", response = OrdersParsingResult.class, consumes = "multipart/form-data", tags = "orders",
            notes = "This operation will create new ordered articles for the given date with the data from the CSV file supplied."
                    + " Depending on the value of the 'X-Overwrite-Orders' headers, it will overwrite the old orders if the header value is 'true',"
                    + " otherwise the new orders will be appended to the old orders.")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Orders validated, parsed and inserted.", response = OrdersParsingResult.class),
            @ApiResponse(code = 415, message = "File type or CSV format not valid.")})
    @PreAuthorize("#oauth2.hasScope('uid') and hasAnyAuthority(@scopeConfiguration.csvUpload)")
    @RequestMapping(value = "/orders", consumes = "multipart/form-data", method = POST, produces = "application/json")
    ResponseEntity<OrdersParsingResult> insertOrdersCSV(
            @ApiParam(value = "CSV file containing the ordered articles.") @RequestParam(name = "file", required = true) MultipartFile file,
            @ApiParam(value = "The date for the orders to be imported.", example = "2017-12-23") @RequestParam String date,
            @RequestHeader(name = "X-Overwrite-Orders", required = true) Boolean overwriteOrders);

    @ApiOperation(value = "Insert Orders from JSON", response = OrdersParsingResult.class, consumes = "application/json", tags = "orders",
            notes = "This operation will create new ordered articles for the given date with the order data supplied."
                    + " Depending on the value of the 'X-Overwrite-Orders' headers, it will overwrite the old orders if the header value is 'true',"
                    + " otherwise the new orders will be appended to the old orders.")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Orders validated, parsed and inserted.", response = OrdersParsingResult.class),
            @ApiResponse(code = 415, message = "Invalid orders.")})
    @PreAuthorize("#oauth2.hasScope(@scopeConfiguration.writeInboundedArticle) or (#oauth2.hasScope('uid') and hasAnyAuthority(@scopeConfiguration.csvUpload))")
    @RequestMapping(value = "/orders", consumes = "application/json", method = POST, produces = "application/json")
    ResponseEntity<OrdersParsingResult> insertOrdersJSON(
            @ApiParam(value = "Array containing the ordered articles.") @RequestBody List<ArticleOrder> orders,
            @ApiParam(value = "The date for the orders to be imported.", example = "2017-12-23") @RequestParam String date,
            @RequestHeader(name = "X-Overwrite-Orders", required = true) boolean overwriteOrders);

    @ApiOperation(produces = "application/json", value = "Get Orders", notes = "This operation will return a response containing a list of orders filtered by the given parameters.", tags = "orders")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Orders retrieved, returning result.")})
    @PreAuthorize("#oauth2.hasScope('uid') and hasAnyAuthority(@scopeConfiguration.csvDownload)")
    @RequestMapping(value = "/orders", method = GET, produces = "application/json")
    ResponseEntity<ArticleOrdersResponse> getArticleOrders(
            @ApiParam(value = "Order date.", example = "2017-12-23") @RequestParam(required = false) String orderDate,
            @ApiParam(value = "Inbound date.", example = "2017-12-23") @RequestParam(required = false) String inboundDate,
            @ApiParam(value = "Production location.", example = "Postbahnhof") @RequestParam(required = false) String productionLocation,
            @ApiParam(value = "Production island.", example = "Styland") @RequestParam(required = false) String productionIsland,
            @ApiParam(value = "Sorting location.", example = "Island Manager") @RequestParam(required = false) String sortingLocation,
            @ApiParam(value = "Inbound status.", example = "true") @RequestParam(required = false) Boolean inbounded);


    @ApiOperation(produces = "text/csv", value = "Get Orders CSV", notes = "This operation will return a CSV with list of orders filtered by the given parameters.", tags = "orders",
            hidden = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Orders retrieved, returning result.")})
    @PreAuthorize("#oauth2.hasScope('uid') and hasAnyAuthority(@scopeConfiguration.csvDownload)")
    @RequestMapping(value = "/orders", method = GET, produces = "text/csv")
    ResponseEntity<Void> getArticleOrdersCSV(HttpServletResponse httpServletResponse,
            @ApiParam(value = "From inbound date", example = "2017-12-23") @RequestParam(required = true) String fromExpectedInboundDate,
            @ApiParam(value = "To inbound date.", example = "2017-12-23") @RequestParam(required = true) String toExpectedInboundDate);


    @ApiOperation(value = "Get Order", notes = "This operation will return an order with the specified order ID.", tags = "orders")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Order retrieved, returning result.")})
    @ApiImplicitParam(name = "orderId", paramType = "path", value = "The order ID.", required = true)
    @PreAuthorize("#oauth2.hasScope('uid') and hasAnyAuthority(@scopeConfiguration.csvDownload)")
    @RequestMapping(value = "/orders/{orderId}", method = GET, produces = "application/json")
    ResponseEntity<ArticleOrder> getArticleOrder(@PathVariable Integer orderId);


    @ApiOperation(value = "Get Order By SKU", notes = "This operation will return an ordered article given its sku", tags = "ordered articles")
    @ApiResponses({@ApiResponse(code = 200, message = "Order retrieved.")})
    @PreAuthorize("#oauth2.hasScope(@scopeConfiguration.readInboundedArticle)")
    @GetMapping(value = "/ordered-articles", produces = "application/json")
    ResponseEntity<ArticleOrder> getArticleOrderBySKU(@ApiParam(value = "The Config SKU.", example = "C2031B04I-918") @RequestParam(name = "sku") String sku);
}
