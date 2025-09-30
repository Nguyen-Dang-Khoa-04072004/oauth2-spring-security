# API SPECIFICATION
### VERSION: 1.0.0
### BASE URI: http://localhost:8082/api/v1
## ENDPOINTS
### GET /products - Get all products
#### Header
```json
{
    "Content-Type":"application/json",
    "Authorization": "Bearer <YOUR_TOKEN>"
}
```
### Response
```
{
    "code": Integer,
    "message": String,
    "product": [
        {
            "id": UUID,
            "productName": String,
            "productImageUrl": String,
            "description": String,
            "measure": Integer,
            "price": Long
        }
    ]
}
```
### GET /products/{productId} - Get a product with specific identity
### Params 
+ productId : UUID
### Header
```json
{
    "Content-Type": "application/json",
    "Authorization": "Bearer <YOUR_TOKEN>"
}
```
### Response
```
{
    "code": Integer,
    "message": String,
    "product": {
        "id": UUID,
        "productName": String,
        "productImageUrl": String,
        "description": String,
        "measure": Integer,
        "price": Long
    }
}
```
### POST /products - create a new product
### Header
```json
{
    "Content-Type": "application/json",
    "Authorization": "Bearer <YOUR_TOKEN>"
}
```
### Body
```
{
    "productName": String,
    "productImageUrl": String,
    "description": String,
    "measure": Integer,
    "price": Long
}
```
### Response
```
{
    "code": Integer,
    "message": String,
    "product": {
        "id": UUID,
        "productName": String,
        "productImageUrl": String,
        "description": String,
        "measure": Integer,
        "price": Long
    }
}
```
### PUT /products/{productId} - update a product's details
### Params 
+ productId : UUID
### Header
```json
{
    "Content-Type": "application/json",
    "Authorization": "Bearer <YOUR_TOKEN>"
}
```
### Body
```
{
    "productName": String,
    "productImageUrl": String,
    "description": String,
    "measure": Integer,
    "price": Long
}
```
### Response
```
{
    "code": Integer,
    "message": String,
    "product": {
        "id": UUID,
        "productName": String,
        "productImageUrl": String,
        "description": String,
        "measure": Integer,
        "price": Long
    }
}
```
### DELETE /products/{productId} - delete a product
### Params 
+ productId : UUID
### Header
```json
{
    "Content-Type": "application/json",
    "Authorization": "Bearer <YOUR_TOKEN>"
}
```
### Response 
No content
