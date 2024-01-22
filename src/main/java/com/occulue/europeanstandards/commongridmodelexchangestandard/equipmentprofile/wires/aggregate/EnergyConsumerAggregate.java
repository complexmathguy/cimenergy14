package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

/**
 * Aggregate handler for EnergyConsumer as outlined for the CQRS pattern, all write responsibilities
 * related to EnergyConsumer are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class EnergyConsumerAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public EnergyConsumerAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public EnergyConsumerAggregate(CreateEnergyConsumerCommand command) throws Exception {
    LOGGER.info("Handling command CreateEnergyConsumerCommand");
    CreateEnergyConsumerEvent event = new CreateEnergyConsumerEvent(command.getEnergyConsumerId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateEnergyConsumerCommand command) throws Exception {
    LOGGER.info("handling command UpdateEnergyConsumerCommand");
    UpdateEnergyConsumerEvent event =
        new UpdateEnergyConsumerEvent(
            command.getEnergyConsumerId(),
            command.getPfixed(),
            command.getPfixedPct(),
            command.getQfixed(),
            command.getQfixedPct(),
            command.getEnergyConsumer());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteEnergyConsumerCommand command) throws Exception {
    LOGGER.info("Handling command DeleteEnergyConsumerCommand");
    apply(new DeleteEnergyConsumerEvent(command.getEnergyConsumerId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignPfixedToEnergyConsumerCommand command) throws Exception {
    LOGGER.info("Handling command AssignPfixedToEnergyConsumerCommand");

    if (pfixed != null && pfixed.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "Pfixed already assigned with id " + command.getAssignment().getActivePowerId());

    apply(
        new AssignPfixedToEnergyConsumerEvent(
            command.getEnergyConsumerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPfixedFromEnergyConsumerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPfixedFromEnergyConsumerCommand");

    if (pfixed == null) throw new ProcessingException("Pfixed already has nothing assigned.");

    apply(new UnAssignPfixedFromEnergyConsumerEvent(command.getEnergyConsumerId()));
  }

  @CommandHandler
  public void handle(AssignPfixedPctToEnergyConsumerCommand command) throws Exception {
    LOGGER.info("Handling command AssignPfixedPctToEnergyConsumerCommand");

    if (pfixedPct != null && pfixedPct.getPerCentId() == command.getAssignment().getPerCentId())
      throw new ProcessingException(
          "PfixedPct already assigned with id " + command.getAssignment().getPerCentId());

    apply(
        new AssignPfixedPctToEnergyConsumerEvent(
            command.getEnergyConsumerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPfixedPctFromEnergyConsumerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPfixedPctFromEnergyConsumerCommand");

    if (pfixedPct == null) throw new ProcessingException("PfixedPct already has nothing assigned.");

    apply(new UnAssignPfixedPctFromEnergyConsumerEvent(command.getEnergyConsumerId()));
  }

  @CommandHandler
  public void handle(AssignQfixedToEnergyConsumerCommand command) throws Exception {
    LOGGER.info("Handling command AssignQfixedToEnergyConsumerCommand");

    if (qfixed != null
        && qfixed.getReactivePowerId() == command.getAssignment().getReactivePowerId())
      throw new ProcessingException(
          "Qfixed already assigned with id " + command.getAssignment().getReactivePowerId());

    apply(
        new AssignQfixedToEnergyConsumerEvent(
            command.getEnergyConsumerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignQfixedFromEnergyConsumerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignQfixedFromEnergyConsumerCommand");

    if (qfixed == null) throw new ProcessingException("Qfixed already has nothing assigned.");

    apply(new UnAssignQfixedFromEnergyConsumerEvent(command.getEnergyConsumerId()));
  }

  @CommandHandler
  public void handle(AssignQfixedPctToEnergyConsumerCommand command) throws Exception {
    LOGGER.info("Handling command AssignQfixedPctToEnergyConsumerCommand");

    if (qfixedPct != null && qfixedPct.getPerCentId() == command.getAssignment().getPerCentId())
      throw new ProcessingException(
          "QfixedPct already assigned with id " + command.getAssignment().getPerCentId());

    apply(
        new AssignQfixedPctToEnergyConsumerEvent(
            command.getEnergyConsumerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignQfixedPctFromEnergyConsumerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignQfixedPctFromEnergyConsumerCommand");

    if (qfixedPct == null) throw new ProcessingException("QfixedPct already has nothing assigned.");

    apply(new UnAssignQfixedPctFromEnergyConsumerEvent(command.getEnergyConsumerId()));
  }

  // multiple association commands
  @CommandHandler
  public void handle(AssignEnergyConsumerToEnergyConsumerCommand command) throws Exception {
    LOGGER.info("Handling command AssignEnergyConsumerToEnergyConsumerCommand");

    if (energyConsumer.contains(command.getAddTo()))
      throw new ProcessingException(
          "EnergyConsumer already contains an entity with id "
              + command.getAddTo().getEnergyConsumerId());

    apply(
        new AssignEnergyConsumerToEnergyConsumerEvent(
            command.getEnergyConsumerId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveEnergyConsumerFromEnergyConsumerCommand command) throws Exception {
    LOGGER.info("Handling command RemoveEnergyConsumerFromEnergyConsumerCommand");

    if (!energyConsumer.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "EnergyConsumer does not contain an entity with id "
              + command.getRemoveFrom().getEnergyConsumerId());

    apply(
        new RemoveEnergyConsumerFromEnergyConsumerEvent(
            command.getEnergyConsumerId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateEnergyConsumerEvent event) {
    LOGGER.info("Event sourcing CreateEnergyConsumerEvent");
    this.energyConsumerId = event.getEnergyConsumerId();
  }

  @EventSourcingHandler
  void on(UpdateEnergyConsumerEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.pfixed = event.getPfixed();
    this.pfixedPct = event.getPfixedPct();
    this.qfixed = event.getQfixed();
    this.qfixedPct = event.getQfixedPct();
    this.energyConsumer = event.getEnergyConsumer();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignPfixedToEnergyConsumerEvent event) {
    LOGGER.info("Event sourcing AssignPfixedToEnergyConsumerEvent");
    this.pfixed = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPfixedFromEnergyConsumerEvent event) {
    LOGGER.info("Event sourcing UnAssignPfixedFromEnergyConsumerEvent");
    this.pfixed = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPfixedPctToEnergyConsumerEvent event) {
    LOGGER.info("Event sourcing AssignPfixedPctToEnergyConsumerEvent");
    this.pfixedPct = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPfixedPctFromEnergyConsumerEvent event) {
    LOGGER.info("Event sourcing UnAssignPfixedPctFromEnergyConsumerEvent");
    this.pfixedPct = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignQfixedToEnergyConsumerEvent event) {
    LOGGER.info("Event sourcing AssignQfixedToEnergyConsumerEvent");
    this.qfixed = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignQfixedFromEnergyConsumerEvent event) {
    LOGGER.info("Event sourcing UnAssignQfixedFromEnergyConsumerEvent");
    this.qfixed = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignQfixedPctToEnergyConsumerEvent event) {
    LOGGER.info("Event sourcing AssignQfixedPctToEnergyConsumerEvent");
    this.qfixedPct = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignQfixedPctFromEnergyConsumerEvent event) {
    LOGGER.info("Event sourcing UnAssignQfixedPctFromEnergyConsumerEvent");
    this.qfixedPct = null;
  }

  // multiple associations
  @EventSourcingHandler
  void on(AssignEnergyConsumerToEnergyConsumerEvent event) {
    LOGGER.info("Event sourcing AssignEnergyConsumerToEnergyConsumerEvent");
    this.energyConsumer.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveEnergyConsumerFromEnergyConsumerEvent event) {
    LOGGER.info("Event sourcing RemoveEnergyConsumerFromEnergyConsumerEvent");
    this.energyConsumer.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID energyConsumerId;

  private ActivePower pfixed = null;
  private PerCent pfixedPct = null;
  private ReactivePower qfixed = null;
  private PerCent qfixedPct = null;
  private Set<EnergyConsumer> energyConsumer = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(EnergyConsumerAggregate.class.getName());
}
