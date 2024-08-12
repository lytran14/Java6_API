package lyttpc05561.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lyttpc05561.Exception.ResourceNotFoundException;
import lyttpc05561.Model.Invoice;
import lyttpc05561.Reponsitory.InvoiceRepository;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {
	@Autowired
	private InvoiceRepository invoiceRepository;

	@GetMapping
	public List<Invoice> getAllInvoices() {
		return invoiceRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Invoice> getInvoiceById(@PathVariable int id) {
		Optional<Invoice> invoice = invoiceRepository.findById(id);
		return invoice.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PutMapping("/{id}")
	public Invoice updateInvoice(@PathVariable int id, @RequestBody Invoice invoiceDetails) {
		Invoice invoice = invoiceRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Invoice not found with id " + id));

		invoice.setInvoiceId(invoiceDetails.getInvoiceId());
		invoice.setPaymentDate(invoiceDetails.getPaymentDate());
		invoice.setPayment_method_id(invoiceDetails.getPayment_method_id());
		invoice.setTotalAmount(invoiceDetails.getTotalAmount());
		invoice.setPaymentDate(invoiceDetails.getPaymentDate());
		invoice.setUsers_id(invoiceDetails.getUsers_id());
		// Set other attributes as needed

		return invoiceRepository.save(invoice);
	}

}
