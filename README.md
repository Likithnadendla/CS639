# Shopping Application for Android

This repository contains the source code for an Android shopping application developed with Kotlin. The app features user authentication, product browsing, and cart management functionality.

## Features

- User authentication.
- Browse products by categories including Sweaters, Shoes, Winter Caps, Perfumes, and Bags.
- Add products to and remove products from the shopping cart.
- View cart summary and place orders.

## Architecture

The application is built using the MVVM (Model-View-ViewModel) architectural pattern. It utilizes the following components:

- **ViewModels**: `LoginViewModel`, `CartViewModel`, and `ProductsViewModel` for handling the presentation logic.
- **Repositories**: `LoginRepository`, `CartRepository`, and `ProductRepository` for data manipulation.
- **Room Database**: For local data storage and retrieval.
- **Hilt**: For dependency injection.

## Setup

To get the project up and running on your local machine for development and testing purposes, follow these steps:

1. Clone the repository:
```bash
git clone https://github.com/Likithnadendla/CS639/tree/FinalProject
