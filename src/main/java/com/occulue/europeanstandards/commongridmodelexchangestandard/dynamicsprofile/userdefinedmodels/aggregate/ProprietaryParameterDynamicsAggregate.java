package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels.aggregate;

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
 * Aggregate handler for ProprietaryParameterDynamics as outlined for the CQRS pattern, all write
 * responsibilities related to ProprietaryParameterDynamics are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ProprietaryParameterDynamicsAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ProprietaryParameterDynamicsAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ProprietaryParameterDynamicsAggregate(CreateProprietaryParameterDynamicsCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateProprietaryParameterDynamicsCommand");
    CreateProprietaryParameterDynamicsEvent event =
        new CreateProprietaryParameterDynamicsEvent(command.getProprietaryParameterDynamicsId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateProprietaryParameterDynamicsCommand command) throws Exception {
    LOGGER.info("handling command UpdateProprietaryParameterDynamicsCommand");
    UpdateProprietaryParameterDynamicsEvent event =
        new UpdateProprietaryParameterDynamicsEvent(
            command.getProprietaryParameterDynamicsId(),
            command.getBooleanParameterValue(),
            command.getFloatParameterValue(),
            command.getIntegerParameterValue(),
            command.getParameterNumber(),
            command.getProprietaryParameterDynamics());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteProprietaryParameterDynamicsCommand command) throws Exception {
    LOGGER.info("Handling command DeleteProprietaryParameterDynamicsCommand");
    apply(new DeleteProprietaryParameterDynamicsEvent(command.getProprietaryParameterDynamicsId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignBooleanParameterValueToProprietaryParameterDynamicsCommand command)
      throws Exception {
    LOGGER.info(
        "Handling command AssignBooleanParameterValueToProprietaryParameterDynamicsCommand");

    if (booleanParameterValue != null
        && booleanParameterValue.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "BooleanParameterValue already assigned with id "
              + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignBooleanParameterValueToProprietaryParameterDynamicsEvent(
            command.getProprietaryParameterDynamicsId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBooleanParameterValueFromProprietaryParameterDynamicsCommand command)
      throws Exception {
    LOGGER.info(
        "Handlign command UnAssignBooleanParameterValueFromProprietaryParameterDynamicsCommand");

    if (booleanParameterValue == null)
      throw new ProcessingException("BooleanParameterValue already has nothing assigned.");

    apply(
        new UnAssignBooleanParameterValueFromProprietaryParameterDynamicsEvent(
            command.getProprietaryParameterDynamicsId()));
  }

  @CommandHandler
  public void handle(AssignFloatParameterValueToProprietaryParameterDynamicsCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignFloatParameterValueToProprietaryParameterDynamicsCommand");

    if (floatParameterValue != null
        && floatParameterValue.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "FloatParameterValue already assigned with id "
              + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignFloatParameterValueToProprietaryParameterDynamicsEvent(
            command.getProprietaryParameterDynamicsId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFloatParameterValueFromProprietaryParameterDynamicsCommand command)
      throws Exception {
    LOGGER.info(
        "Handlign command UnAssignFloatParameterValueFromProprietaryParameterDynamicsCommand");

    if (floatParameterValue == null)
      throw new ProcessingException("FloatParameterValue already has nothing assigned.");

    apply(
        new UnAssignFloatParameterValueFromProprietaryParameterDynamicsEvent(
            command.getProprietaryParameterDynamicsId()));
  }

  @CommandHandler
  public void handle(AssignIntegerParameterValueToProprietaryParameterDynamicsCommand command)
      throws Exception {
    LOGGER.info(
        "Handling command AssignIntegerParameterValueToProprietaryParameterDynamicsCommand");

    if (integerParameterValue != null
        && integerParameterValue.getIntegerProxyId() == command.getAssignment().getIntegerProxyId())
      throw new ProcessingException(
          "IntegerParameterValue already assigned with id "
              + command.getAssignment().getIntegerProxyId());

    apply(
        new AssignIntegerParameterValueToProprietaryParameterDynamicsEvent(
            command.getProprietaryParameterDynamicsId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignIntegerParameterValueFromProprietaryParameterDynamicsCommand command)
      throws Exception {
    LOGGER.info(
        "Handlign command UnAssignIntegerParameterValueFromProprietaryParameterDynamicsCommand");

    if (integerParameterValue == null)
      throw new ProcessingException("IntegerParameterValue already has nothing assigned.");

    apply(
        new UnAssignIntegerParameterValueFromProprietaryParameterDynamicsEvent(
            command.getProprietaryParameterDynamicsId()));
  }

  @CommandHandler
  public void handle(AssignParameterNumberToProprietaryParameterDynamicsCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignParameterNumberToProprietaryParameterDynamicsCommand");

    if (parameterNumber != null
        && parameterNumber.getIntegerProxyId() == command.getAssignment().getIntegerProxyId())
      throw new ProcessingException(
          "ParameterNumber already assigned with id "
              + command.getAssignment().getIntegerProxyId());

    apply(
        new AssignParameterNumberToProprietaryParameterDynamicsEvent(
            command.getProprietaryParameterDynamicsId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignParameterNumberFromProprietaryParameterDynamicsCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignParameterNumberFromProprietaryParameterDynamicsCommand");

    if (parameterNumber == null)
      throw new ProcessingException("ParameterNumber already has nothing assigned.");

    apply(
        new UnAssignParameterNumberFromProprietaryParameterDynamicsEvent(
            command.getProprietaryParameterDynamicsId()));
  }

  // multiple association commands
  @CommandHandler
  public void handle(
      AssignProprietaryParameterDynamicsToProprietaryParameterDynamicsCommand command)
      throws Exception {
    LOGGER.info(
        "Handling command AssignProprietaryParameterDynamicsToProprietaryParameterDynamicsCommand");

    if (proprietaryParameterDynamics.contains(command.getAddTo()))
      throw new ProcessingException(
          "ProprietaryParameterDynamics already contains an entity with id "
              + command.getAddTo().getProprietaryParameterDynamicsId());

    apply(
        new AssignProprietaryParameterDynamicsToProprietaryParameterDynamicsEvent(
            command.getProprietaryParameterDynamicsId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(
      RemoveProprietaryParameterDynamicsFromProprietaryParameterDynamicsCommand command)
      throws Exception {
    LOGGER.info(
        "Handling command RemoveProprietaryParameterDynamicsFromProprietaryParameterDynamicsCommand");

    if (!proprietaryParameterDynamics.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "ProprietaryParameterDynamics does not contain an entity with id "
              + command.getRemoveFrom().getProprietaryParameterDynamicsId());

    apply(
        new RemoveProprietaryParameterDynamicsFromProprietaryParameterDynamicsEvent(
            command.getProprietaryParameterDynamicsId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateProprietaryParameterDynamicsEvent event) {
    LOGGER.info("Event sourcing CreateProprietaryParameterDynamicsEvent");
    this.proprietaryParameterDynamicsId = event.getProprietaryParameterDynamicsId();
  }

  @EventSourcingHandler
  void on(UpdateProprietaryParameterDynamicsEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.booleanParameterValue = event.getBooleanParameterValue();
    this.floatParameterValue = event.getFloatParameterValue();
    this.integerParameterValue = event.getIntegerParameterValue();
    this.parameterNumber = event.getParameterNumber();
    this.proprietaryParameterDynamics = event.getProprietaryParameterDynamics();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignBooleanParameterValueToProprietaryParameterDynamicsEvent event) {
    LOGGER.info("Event sourcing AssignBooleanParameterValueToProprietaryParameterDynamicsEvent");
    this.booleanParameterValue = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBooleanParameterValueFromProprietaryParameterDynamicsEvent event) {
    LOGGER.info(
        "Event sourcing UnAssignBooleanParameterValueFromProprietaryParameterDynamicsEvent");
    this.booleanParameterValue = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFloatParameterValueToProprietaryParameterDynamicsEvent event) {
    LOGGER.info("Event sourcing AssignFloatParameterValueToProprietaryParameterDynamicsEvent");
    this.floatParameterValue = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFloatParameterValueFromProprietaryParameterDynamicsEvent event) {
    LOGGER.info("Event sourcing UnAssignFloatParameterValueFromProprietaryParameterDynamicsEvent");
    this.floatParameterValue = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignIntegerParameterValueToProprietaryParameterDynamicsEvent event) {
    LOGGER.info("Event sourcing AssignIntegerParameterValueToProprietaryParameterDynamicsEvent");
    this.integerParameterValue = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignIntegerParameterValueFromProprietaryParameterDynamicsEvent event) {
    LOGGER.info(
        "Event sourcing UnAssignIntegerParameterValueFromProprietaryParameterDynamicsEvent");
    this.integerParameterValue = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignParameterNumberToProprietaryParameterDynamicsEvent event) {
    LOGGER.info("Event sourcing AssignParameterNumberToProprietaryParameterDynamicsEvent");
    this.parameterNumber = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignParameterNumberFromProprietaryParameterDynamicsEvent event) {
    LOGGER.info("Event sourcing UnAssignParameterNumberFromProprietaryParameterDynamicsEvent");
    this.parameterNumber = null;
  }

  // multiple associations
  @EventSourcingHandler
  void on(AssignProprietaryParameterDynamicsToProprietaryParameterDynamicsEvent event) {
    LOGGER.info(
        "Event sourcing AssignProprietaryParameterDynamicsToProprietaryParameterDynamicsEvent");
    this.proprietaryParameterDynamics.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveProprietaryParameterDynamicsFromProprietaryParameterDynamicsEvent event) {
    LOGGER.info(
        "Event sourcing RemoveProprietaryParameterDynamicsFromProprietaryParameterDynamicsEvent");
    this.proprietaryParameterDynamics.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID proprietaryParameterDynamicsId;

  private BooleanProxy booleanParameterValue = null;
  private Simple_Float floatParameterValue = null;
  private IntegerProxy integerParameterValue = null;
  private IntegerProxy parameterNumber = null;
  private Set<ProprietaryParameterDynamics> proprietaryParameterDynamics = new HashSet<>();

  private static final Logger LOGGER =
      Logger.getLogger(ProprietaryParameterDynamicsAggregate.class.getName());
}
