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
 * Aggregate handler for TransformerEnd as outlined for the CQRS pattern, all write responsibilities
 * related to TransformerEnd are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class TransformerEndAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public TransformerEndAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public TransformerEndAggregate(CreateTransformerEndCommand command) throws Exception {
    LOGGER.info("Handling command CreateTransformerEndCommand");
    CreateTransformerEndEvent event = new CreateTransformerEndEvent(command.getTransformerEndId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateTransformerEndCommand command) throws Exception {
    LOGGER.info("handling command UpdateTransformerEndCommand");
    UpdateTransformerEndEvent event =
        new UpdateTransformerEndEvent(
            command.getTransformerEndId(),
            command.getEndNumber(),
            command.getGrounded(),
            command.getRground(),
            command.getXground(),
            command.getTransformerEnds(),
            command.getTransformerEnd());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteTransformerEndCommand command) throws Exception {
    LOGGER.info("Handling command DeleteTransformerEndCommand");
    apply(new DeleteTransformerEndEvent(command.getTransformerEndId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignEndNumberToTransformerEndCommand command) throws Exception {
    LOGGER.info("Handling command AssignEndNumberToTransformerEndCommand");

    if (endNumber != null
        && endNumber.getIntegerProxyId() == command.getAssignment().getIntegerProxyId())
      throw new ProcessingException(
          "EndNumber already assigned with id " + command.getAssignment().getIntegerProxyId());

    apply(
        new AssignEndNumberToTransformerEndEvent(
            command.getTransformerEndId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEndNumberFromTransformerEndCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEndNumberFromTransformerEndCommand");

    if (endNumber == null) throw new ProcessingException("EndNumber already has nothing assigned.");

    apply(new UnAssignEndNumberFromTransformerEndEvent(command.getTransformerEndId()));
  }

  @CommandHandler
  public void handle(AssignGroundedToTransformerEndCommand command) throws Exception {
    LOGGER.info("Handling command AssignGroundedToTransformerEndCommand");

    if (grounded != null
        && grounded.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Grounded already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignGroundedToTransformerEndEvent(
            command.getTransformerEndId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGroundedFromTransformerEndCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGroundedFromTransformerEndCommand");

    if (grounded == null) throw new ProcessingException("Grounded already has nothing assigned.");

    apply(new UnAssignGroundedFromTransformerEndEvent(command.getTransformerEndId()));
  }

  @CommandHandler
  public void handle(AssignRgroundToTransformerEndCommand command) throws Exception {
    LOGGER.info("Handling command AssignRgroundToTransformerEndCommand");

    if (rground != null && rground.getResistanceId() == command.getAssignment().getResistanceId())
      throw new ProcessingException(
          "Rground already assigned with id " + command.getAssignment().getResistanceId());

    apply(
        new AssignRgroundToTransformerEndEvent(
            command.getTransformerEndId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRgroundFromTransformerEndCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignRgroundFromTransformerEndCommand");

    if (rground == null) throw new ProcessingException("Rground already has nothing assigned.");

    apply(new UnAssignRgroundFromTransformerEndEvent(command.getTransformerEndId()));
  }

  @CommandHandler
  public void handle(AssignXgroundToTransformerEndCommand command) throws Exception {
    LOGGER.info("Handling command AssignXgroundToTransformerEndCommand");

    if (xground != null && xground.getReactanceId() == command.getAssignment().getReactanceId())
      throw new ProcessingException(
          "Xground already assigned with id " + command.getAssignment().getReactanceId());

    apply(
        new AssignXgroundToTransformerEndEvent(
            command.getTransformerEndId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXgroundFromTransformerEndCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignXgroundFromTransformerEndCommand");

    if (xground == null) throw new ProcessingException("Xground already has nothing assigned.");

    apply(new UnAssignXgroundFromTransformerEndEvent(command.getTransformerEndId()));
  }

  // multiple association commands
  @CommandHandler
  public void handle(AssignTransformerEndsToTransformerEndCommand command) throws Exception {
    LOGGER.info("Handling command AssignTransformerEndsToTransformerEndCommand");

    if (transformerEnds.contains(command.getAddTo()))
      throw new ProcessingException(
          "TransformerEnds already contains an entity with id "
              + command.getAddTo().getTransformerEndId());

    apply(
        new AssignTransformerEndsToTransformerEndEvent(
            command.getTransformerEndId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveTransformerEndsFromTransformerEndCommand command) throws Exception {
    LOGGER.info("Handling command RemoveTransformerEndsFromTransformerEndCommand");

    if (!transformerEnds.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "TransformerEnds does not contain an entity with id "
              + command.getRemoveFrom().getTransformerEndId());

    apply(
        new RemoveTransformerEndsFromTransformerEndEvent(
            command.getTransformerEndId(), command.getRemoveFrom()));
  }

  @CommandHandler
  public void handle(AssignTransformerEndToTransformerEndCommand command) throws Exception {
    LOGGER.info("Handling command AssignTransformerEndToTransformerEndCommand");

    if (transformerEnd.contains(command.getAddTo()))
      throw new ProcessingException(
          "TransformerEnd already contains an entity with id "
              + command.getAddTo().getTransformerEndId());

    apply(
        new AssignTransformerEndToTransformerEndEvent(
            command.getTransformerEndId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveTransformerEndFromTransformerEndCommand command) throws Exception {
    LOGGER.info("Handling command RemoveTransformerEndFromTransformerEndCommand");

    if (!transformerEnd.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "TransformerEnd does not contain an entity with id "
              + command.getRemoveFrom().getTransformerEndId());

    apply(
        new RemoveTransformerEndFromTransformerEndEvent(
            command.getTransformerEndId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateTransformerEndEvent event) {
    LOGGER.info("Event sourcing CreateTransformerEndEvent");
    this.transformerEndId = event.getTransformerEndId();
  }

  @EventSourcingHandler
  void on(UpdateTransformerEndEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.endNumber = event.getEndNumber();
    this.grounded = event.getGrounded();
    this.rground = event.getRground();
    this.xground = event.getXground();
    this.transformerEnds = event.getTransformerEnds();
    this.transformerEnd = event.getTransformerEnd();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignEndNumberToTransformerEndEvent event) {
    LOGGER.info("Event sourcing AssignEndNumberToTransformerEndEvent");
    this.endNumber = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEndNumberFromTransformerEndEvent event) {
    LOGGER.info("Event sourcing UnAssignEndNumberFromTransformerEndEvent");
    this.endNumber = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignGroundedToTransformerEndEvent event) {
    LOGGER.info("Event sourcing AssignGroundedToTransformerEndEvent");
    this.grounded = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGroundedFromTransformerEndEvent event) {
    LOGGER.info("Event sourcing UnAssignGroundedFromTransformerEndEvent");
    this.grounded = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRgroundToTransformerEndEvent event) {
    LOGGER.info("Event sourcing AssignRgroundToTransformerEndEvent");
    this.rground = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRgroundFromTransformerEndEvent event) {
    LOGGER.info("Event sourcing UnAssignRgroundFromTransformerEndEvent");
    this.rground = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXgroundToTransformerEndEvent event) {
    LOGGER.info("Event sourcing AssignXgroundToTransformerEndEvent");
    this.xground = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXgroundFromTransformerEndEvent event) {
    LOGGER.info("Event sourcing UnAssignXgroundFromTransformerEndEvent");
    this.xground = null;
  }

  // multiple associations
  @EventSourcingHandler
  void on(AssignTransformerEndsToTransformerEndEvent event) {
    LOGGER.info("Event sourcing AssignTransformerEndsToTransformerEndEvent");
    this.transformerEnds.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveTransformerEndsFromTransformerEndEvent event) {
    LOGGER.info("Event sourcing RemoveTransformerEndsFromTransformerEndEvent");
    this.transformerEnds.remove(event.getRemoveFrom());
  }

  // multiple associations
  @EventSourcingHandler
  void on(AssignTransformerEndToTransformerEndEvent event) {
    LOGGER.info("Event sourcing AssignTransformerEndToTransformerEndEvent");
    this.transformerEnd.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveTransformerEndFromTransformerEndEvent event) {
    LOGGER.info("Event sourcing RemoveTransformerEndFromTransformerEndEvent");
    this.transformerEnd.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID transformerEndId;

  private IntegerProxy endNumber = null;
  private BooleanProxy grounded = null;
  private Resistance rground = null;
  private Reactance xground = null;
  private Set<TransformerEnd> transformerEnds = new HashSet<>();
  private Set<TransformerEnd> transformerEnd = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(TransformerEndAggregate.class.getName());
}
