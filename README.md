# NewsletterAPI
Welcome! Here you will find an API responsible for sending newsletters for subscribers.

## 💻 Getting started

### Requirements

- [Kotlin](https://kotlinlang.org/)
- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Docker](https://www.docker.com/)

**Clone the project**

```bash
$ git clone https://github.com/gabrielmesquita8/NewsletterApi.git

$ cd newsletter

$ docker-compose up
```

**Export postman folder**

1. **Open Postman:**
   - Launch the Postman application.

2. **Import the Collection:**
   - Click on **Import** in the top left corner of the Postman interface.
   - Select the file from the `postman_collections` folder and import it.

3. **Use the Requests:**
   - Once imported, you will have access to the configured requests for use with the NewsletterAPI.

**How to use the API**

1. **Create the Main Data:**
   - **Add subscriber:**
     - First, execute the `addSubscriber` request in Postman.
   - **Add newsletter:**
     - Next, execute the `addNewsletter` request in Postman.
   - **Send email:**
     - Finally, add your username (email) and password on `application yaml`. Execute the `sendEmail` request in Postman. 
     - Unfortunately, Google no longer allows apps of this type to send emails. You will need to change your login method for it to work.