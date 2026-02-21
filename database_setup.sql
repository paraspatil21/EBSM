-- Final SQL Setup Script for Electricity Billing System
-- Database Setup
CREATE DATABASE IF NOT EXISTS ebs;
USE ebs;

-- 1. Login Table
CREATE TABLE IF NOT EXISTS login (
    username VARCHAR(100),
    password VARCHAR(100)
);

-- 2. Customer Table (emp)
CREATE TABLE IF NOT EXISTS emp (
    name VARCHAR(100), 
    meter_number VARCHAR(100), 
    address VARCHAR(200), 
    state VARCHAR(100), 
    city VARCHAR(100), 
    email VARCHAR(100), 
    phone VARCHAR(100)
);

-- 3. Tax Table
CREATE TABLE IF NOT EXISTS tax (
    meter_location VARCHAR(50), 
    meter_type VARCHAR(50), 
    phase_code VARCHAR(50), 
    bill_type VARCHAR(50), 
    days VARCHAR(20), 
    meter_rent VARCHAR(20), 
    mcb_rent VARCHAR(20), 
    service_rent VARCHAR(20), 
    gst VARCHAR(20)
);

-- 4. Bill Table
CREATE TABLE IF NOT EXISTS bill (
    meter_number VARCHAR(50), 
    month VARCHAR(50), 
    units VARCHAR(50), 
    amount VARCHAR(50)
);

-- Default Data Seeding
-- Insert Default Admin
INSERT INTO login (username, password) VALUES ('admin', 'admin');

-- Insert Base Tax Configurations (required for bill generation)
INSERT INTO tax VALUES ('Outside', 'Indoor', '011', 'Normal', '30', '250', '200', '150', '100');
