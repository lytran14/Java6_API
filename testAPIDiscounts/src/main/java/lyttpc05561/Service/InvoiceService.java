package lyttpc05561.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lyttpc05561.Exception.ResourceNotFoundException;
import lyttpc05561.Model.Discount;
import lyttpc05561.Model.Invoice;
import lyttpc05561.Reponsitory.InvoiceRepository;

@Service
public class InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;

	public List<Invoice> getAllInvoices() {
		return invoiceRepository.findAll();
	}
	
    public Optional<Invoice> getInvoiceById(int id) {
        return invoiceRepository.findById(id);
    }

	public Invoice updateInvoice(int id, Invoice invoiceDetails) {
		Invoice invoice = invoiceRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Invoice not found"));

		invoice.setInvoiceId(invoiceDetails.getInvoiceId());
		invoice.setTotalAmount(invoiceDetails.getTotalAmount());
		invoice.setPaymentDate(invoiceDetails.getPaymentDate());
		invoice.setTotalAmount(invoiceDetails.getTotalAmount());
		invoice.setPaymentDate(invoiceDetails.getPaymentDate());
		invoice.setUsers_id(invoiceDetails.getUsers_id());
		// Set other attributes as needed

		return invoiceRepository.save(invoice);
	}
}
