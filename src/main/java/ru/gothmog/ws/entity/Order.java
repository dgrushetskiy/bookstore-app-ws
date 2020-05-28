package ru.gothmog.ws.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders",schema = "book_dbo")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(name = "order_date")
    private LocalDateTime orderDate;
    @Column(name = "order_total")
    private BigDecimal orderTotal;
    @Column(name = "status",length = 20)
    private String status;
    @Column(name = "shipping_address",length = 256)
    private String shippingAddress;
    @Column(name = "payment_method",length = 20)
    private String paymentMethod;
    @Column(name = "recipient_name",length = 30)
    private String recipientName;
    @Column(name = "recipient_phone",length = 15)
    private String recipientPhone;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<OrderDetail> orderDetails = new HashSet<>();
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false, foreignKey = @ForeignKey(name = "fk_order_customer"))
    private Customer customer;
}
