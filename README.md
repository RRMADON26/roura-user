# Roura - A Quora-like Question and Answer Application

Roura is an open-source web application that allows users to ask questions, provide answers, and engage in discussions on various topics, similar to Quora. This README provides an overview of Roura, its features, setup instructions, and guidelines for contributing.

## Table of Contents

1. [Features](#features)
2. [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
3. [Usage](#usage)
4. [Contributing](#contributing)
5. [License](#license)

## Features

- User registration and authentication.
- Posting questions and answers.
- Upvoting and downvoting answers.
- Commenting on questions and answers.
- Tagging questions for easy categorization.
- User profiles and activity feeds.
- Search functionality to find questions and answers.
- Moderation features to manage content.
- Notifications for user interactions.


## Introduction

Welcome to the Firebase Authentication Repository!

This repository serves as a comprehensive resource for implementing user authentication using Firebase Authentication services in your web or mobile applications. Firebase Authentication is a powerful and easy-to-use authentication solution provided by Google's Firebase platform. It allows you to quickly integrate user authentication features like registration, login, password reset, and more into your application with minimal effort.

### What is Firebase Authentication?

Firebase Authentication is a part of the Firebase suite of tools and services designed to streamline the development process for web and mobile applications. With Firebase Authentication, you can:

- Authenticate users using a variety of methods, including email/password, phone number, Google, Facebook, and more.
- Manage user accounts, profiles, and custom user data.
- Implement fine-grained access control and authorization rules.
- Enhance security with features like multi-factor authentication (MFA).
- Easily integrate authentication into popular frameworks and libraries.

### Why Use Firebase Authentication?

Firebase Authentication offers several advantages for developers:

1. **Security**: Firebase Authentication provides robust security features, including secure password hashing, OAuth-based authentication, and token-based user sessions.

2. **Ease of Use**: It simplifies the process of integrating authentication into your app, reducing development time and complexity.

3. **Scalability**: Firebase Authentication scales with your application, accommodating a growing user base effortlessly.

4. **Cross-Platform**: Firebase Authentication supports web, iOS, Android, and other platforms, ensuring a consistent authentication experience for your users.

In this repository, you will find documentation, code samples, and best practices for implementing Firebase Authentication effectively in your projects. Whether you're a beginner looking to get started or an experienced developer seeking advanced authentication features, this repository has you covered.

Feel free to explore the provided resources, contribute to the project, or ask questions in the issue tracker. We're excited to help you leverage Firebase Authentication to build secure and user-friendly applications!

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/roura-users-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- RESTEasy Classic ([guide](https://quarkus.io/guides/resteasy)): REST endpoint framework implementing Jakarta REST and
  more

## Provided Code

### RESTEasy JAX-RS

Easily start your RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)
