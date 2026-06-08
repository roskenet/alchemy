# Core concepts of Elasticsearch

Elasticsearch is primarily designed to be interacted with via a **RESTful API**. This 
means that almost every action you perform in Elasticsearch—creating an index, searching 
for documents, updating data, or managing cluster settings—is done by sending HTTP 
requests (GET, POST, PUT, DELETE) accompanied by a JSON body.

Here is a brief breakdown of the core concepts of the Elasticsearch API.

---

### 1. The Request Structure
When you interact with the API, a typical request consists of:
*   **An HTTP Method:** (e.g., `GET` for retrieving data, `POST` for creating it).
*   **A URL Path:** This defines the target (e.g., `/my_index/_search`).
*   **A JSON Body:** This contains the specific parameters or the data you want to send.

### 2. Key Concepts in the API
To understand the API, you need to know the three main components it manages:

*   **Index:** Think of this as a "collection" or a "table." It is a logical grouping of 
documents (e.g., `products`, `logs`, `users`).
*   **Document:** This is a single "record" stored in an index. Documents are stored in 
**JSON format**.
*   **Mapping:** This defines the "schema." It tells Elasticsearch what fields exist in 
your document and what data types they are (e.g., `text`, `integer`, `date`).

### 3. Common API Operations (CRUD)
Most interactions follow standard CRUD patterns:

#### Create/Index a Document
To add a new item to an index, you use `PUT` or `POST`.
```http
# PUT /index_name/_doc/id
PUT /products/_doc/1
{
  "name": "Wireless Mouse",
  "price": 25.99,
  "category": "Electronics"
}
```

#### Search for Documents
The most common way to interact with data is the `_search` endpoint. It supports a 
**Query DSL** (Domain Specific Language), which allows for complex filtering and sorting.
```http
# GET /index_name/_search
GET /products/_search
{
  "query": {
    "match": {
      "category": "Electronics"
    }
  }
}
```

#### Update a Document
To change an existing document, you use the `_update` endpoint.
```http
PUT /products/_update/1
{
  "doc": {
    "price": 29.99
  }
}
```

#### Delete Data
You can delete specific documents or entire indices.
```http
DELETE /products/_doc/1   # Deletes the "Wireless Mouse"
DELETE /products           # Deletes the entire index
```

### 4. Advanced Features of the API
The power of the Elasticsearch API lies in its advanced search capabilities:

*   **Full-Text Search:** The `match` query handles fuzzy logic, synonyms, and "did you 
mean?" corrections automatically.
*   **Aggregations:** This is like "Group By" in SQL. It allows you to calculate 
statistics (e.g., "What is the average price of electronics?").
*   **Filters:** Used when you want to narrow results based on exact values (like a date 
range or status) without affecting the search score.
*   **Pagination:** The API handles large datasets using `from` and `size` parameters.

### 5. How to interact with it
While you can use `curl` in your terminal to send raw HTTP requests, most developers use 
official **Client Libraries**. These libraries wrap the REST calls into native code:
*   **Python:** `elasticsearch-py`
*   **JavaScript/Node.js:** `@elastic/elasticsearch`
*   **Java/Kotlin:** Official Elastic Java Client
*   **Go:** `go-elasticsearch`

### Summary Table
| Action | HTTP Method | Endpoint Example | Purpose |
| :--- | :--- | :--- | |
| **Create Index** | `PUT` | `/my_index` | Creates the container. |
| **Index Doc** | `PUT`/`POST` | `/my_index/_doc/1` | Adds a single record. |
| **Search** | `GET` | `/my_index/_search` | Finds data based on query. |
| **Update** | `POST` | `/my_index/_update/1` | Modifies an existing doc. |
| **Delete** | `DELETE` | `/my_index/_doc/1` | Removes a record. |

