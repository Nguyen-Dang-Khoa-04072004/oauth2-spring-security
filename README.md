# FPT Food Store
A simple food store website allows users to securely log in with FPT Food Store account. The site supports Single Sign-On (SSO) using a custom-built authentication system powered by Spring Security and Oauth2 client is implemented by myself. Users can authenticate once through a central identity server and seamlessly access multiple services within the platform without logging in again. This setup improves user experience and enforces consistent security across all applications. 
# Requirements
+ Java 21
+ Maven
+ Node
# Technologies
Backend
+ Spring boot
+ Spring data JPA
+ Spring security
+ Spring resource server
+ Spring authorization server
Frontend
+ reactJS
+ redux toolkit
+ axios
# Installation
1. clone the repo
```bash
git clone https://github.com/Nguyen-Dang-Khoa-04072004/oauth2-spring-security
```
2. install dependencies for client app
```bash
cd client-app
npm install
```
3. run the client app
```bash
npm run dev
```
4. run the authorization server
```bash
cd authorization-sever
mvn spring-boot:run
```
5. run the resource server
```bash
cd resource server
mvn spring-boot:run
```
# DOCUMENTS
+ [API Specification](./docs/API.md)
+ [Data Dictionary](./docs/data-dictionary.md)
+ [Sequence Diagram](./images/sequence-diagram.png)
+ [ERD Diagram](./images/erd-diagram-v1.png)

# SCREEN SHOTS
## LANDING PAGE
![Landing Page](./images/screen-shot-1.png)
## PRODUCT PAGE
![Product Page](./images/screen-shot-2.png)
# DEMO 
## Oauth2 client log in
![Oauth client log in demo](https://github.com/user-attachments/assets/2b6a2b58-899f-47ca-a0eb-6b3f2122d1e2)
