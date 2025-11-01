package com.ElectronicsService.Electronic.Service.repository;

import com.ElectronicsService.Electronic.Service.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
