# DATA DICTIONARY   
## USER TABLE
| Column | Data type | Description |
|:---|:---|:---|
| user_id | bigint | user's identity |
| username | nvarchar | user's name |
| password | nvarchar | user's bcrypt encoded password|
| email | nvarchar | user's email |
| profile_image_url | nvarchar | URL of profile image |
| role | enum("ROLE_user", "ROLE_admin") | user's role |
## PRODUCT TABLE
| Column | Data type | Description |
|:---|:---|:---|
| product_id | nvarchar | product's identity |
| product_name | nvarchar | product's name |
| price | bigint | product's price|
| measure | int | product's measure |
| product_image_url | nvarchar | URL of product image |
| description | nvarchar | product's description |