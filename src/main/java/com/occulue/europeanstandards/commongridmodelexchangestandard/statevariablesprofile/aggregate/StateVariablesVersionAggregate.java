package com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.aggregate;

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
 * Aggregate handler for StateVariablesVersion as outlined for the CQRS pattern, all write
 * responsibilities related to StateVariablesVersion are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class StateVariablesVersionAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public StateVariablesVersionAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public StateVariablesVersionAggregate(CreateStateVariablesVersionCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateStateVariablesVersionCommand");
    CreateStateVariablesVersionEvent event =
        new CreateStateVariablesVersionEvent(command.getStateVariablesVersionId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateStateVariablesVersionCommand command) throws Exception {
    LOGGER.info("handling command UpdateStateVariablesVersionCommand");
    UpdateStateVariablesVersionEvent event =
        new UpdateStateVariablesVersionEvent(
            command.getStateVariablesVersionId(),
            command.getBaseUML(),
            command.getBaseURI(),
            command.getDate(),
            command.getDifferenceModelURI(),
            command.getEntsoeUML(),
            command.getEntsoeURI(),
            command.getModelDescriptionURI(),
            command.getNamespaceRDF(),
            command.getNamespaceUML(),
            command.getShortName());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteStateVariablesVersionCommand command) throws Exception {
    LOGGER.info("Handling command DeleteStateVariablesVersionCommand");
    apply(new DeleteStateVariablesVersionEvent(command.getStateVariablesVersionId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignBaseUMLToStateVariablesVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignBaseUMLToStateVariablesVersionCommand");

    if (baseUML != null && baseUML.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "BaseUML already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignBaseUMLToStateVariablesVersionEvent(
            command.getStateVariablesVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBaseUMLFromStateVariablesVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignBaseUMLFromStateVariablesVersionCommand");

    if (baseUML == null) throw new ProcessingException("BaseUML already has nothing assigned.");

    apply(new UnAssignBaseUMLFromStateVariablesVersionEvent(command.getStateVariablesVersionId()));
  }

  @CommandHandler
  public void handle(AssignBaseURIToStateVariablesVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignBaseURIToStateVariablesVersionCommand");

    if (baseURI != null && baseURI.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "BaseURI already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignBaseURIToStateVariablesVersionEvent(
            command.getStateVariablesVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBaseURIFromStateVariablesVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignBaseURIFromStateVariablesVersionCommand");

    if (baseURI == null) throw new ProcessingException("BaseURI already has nothing assigned.");

    apply(new UnAssignBaseURIFromStateVariablesVersionEvent(command.getStateVariablesVersionId()));
  }

  @CommandHandler
  public void handle(AssignDateToStateVariablesVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignDateToStateVariablesVersionCommand");

    if (date != null && date.getDateProxyId() == command.getAssignment().getDateProxyId())
      throw new ProcessingException(
          "Date already assigned with id " + command.getAssignment().getDateProxyId());

    apply(
        new AssignDateToStateVariablesVersionEvent(
            command.getStateVariablesVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDateFromStateVariablesVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDateFromStateVariablesVersionCommand");

    if (date == null) throw new ProcessingException("Date already has nothing assigned.");

    apply(new UnAssignDateFromStateVariablesVersionEvent(command.getStateVariablesVersionId()));
  }

  @CommandHandler
  public void handle(AssignDifferenceModelURIToStateVariablesVersionCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignDifferenceModelURIToStateVariablesVersionCommand");

    if (differenceModelURI != null
        && differenceModelURI.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "DifferenceModelURI already assigned with id "
              + command.getAssignment().getStringProxyId());

    apply(
        new AssignDifferenceModelURIToStateVariablesVersionEvent(
            command.getStateVariablesVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDifferenceModelURIFromStateVariablesVersionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignDifferenceModelURIFromStateVariablesVersionCommand");

    if (differenceModelURI == null)
      throw new ProcessingException("DifferenceModelURI already has nothing assigned.");

    apply(
        new UnAssignDifferenceModelURIFromStateVariablesVersionEvent(
            command.getStateVariablesVersionId()));
  }

  @CommandHandler
  public void handle(AssignEntsoeUMLToStateVariablesVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignEntsoeUMLToStateVariablesVersionCommand");

    if (entsoeUML != null
        && entsoeUML.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "EntsoeUML already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignEntsoeUMLToStateVariablesVersionEvent(
            command.getStateVariablesVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEntsoeUMLFromStateVariablesVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEntsoeUMLFromStateVariablesVersionCommand");

    if (entsoeUML == null) throw new ProcessingException("EntsoeUML already has nothing assigned.");

    apply(
        new UnAssignEntsoeUMLFromStateVariablesVersionEvent(command.getStateVariablesVersionId()));
  }

  @CommandHandler
  public void handle(AssignEntsoeURIToStateVariablesVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignEntsoeURIToStateVariablesVersionCommand");

    if (entsoeURI != null
        && entsoeURI.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "EntsoeURI already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignEntsoeURIToStateVariablesVersionEvent(
            command.getStateVariablesVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEntsoeURIFromStateVariablesVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEntsoeURIFromStateVariablesVersionCommand");

    if (entsoeURI == null) throw new ProcessingException("EntsoeURI already has nothing assigned.");

    apply(
        new UnAssignEntsoeURIFromStateVariablesVersionEvent(command.getStateVariablesVersionId()));
  }

  @CommandHandler
  public void handle(AssignModelDescriptionURIToStateVariablesVersionCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignModelDescriptionURIToStateVariablesVersionCommand");

    if (modelDescriptionURI != null
        && modelDescriptionURI.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "ModelDescriptionURI already assigned with id "
              + command.getAssignment().getStringProxyId());

    apply(
        new AssignModelDescriptionURIToStateVariablesVersionEvent(
            command.getStateVariablesVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignModelDescriptionURIFromStateVariablesVersionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignModelDescriptionURIFromStateVariablesVersionCommand");

    if (modelDescriptionURI == null)
      throw new ProcessingException("ModelDescriptionURI already has nothing assigned.");

    apply(
        new UnAssignModelDescriptionURIFromStateVariablesVersionEvent(
            command.getStateVariablesVersionId()));
  }

  @CommandHandler
  public void handle(AssignNamespaceRDFToStateVariablesVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignNamespaceRDFToStateVariablesVersionCommand");

    if (namespaceRDF != null
        && namespaceRDF.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "NamespaceRDF already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignNamespaceRDFToStateVariablesVersionEvent(
            command.getStateVariablesVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNamespaceRDFFromStateVariablesVersionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignNamespaceRDFFromStateVariablesVersionCommand");

    if (namespaceRDF == null)
      throw new ProcessingException("NamespaceRDF already has nothing assigned.");

    apply(
        new UnAssignNamespaceRDFFromStateVariablesVersionEvent(
            command.getStateVariablesVersionId()));
  }

  @CommandHandler
  public void handle(AssignNamespaceUMLToStateVariablesVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignNamespaceUMLToStateVariablesVersionCommand");

    if (namespaceUML != null
        && namespaceUML.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "NamespaceUML already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignNamespaceUMLToStateVariablesVersionEvent(
            command.getStateVariablesVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNamespaceUMLFromStateVariablesVersionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignNamespaceUMLFromStateVariablesVersionCommand");

    if (namespaceUML == null)
      throw new ProcessingException("NamespaceUML already has nothing assigned.");

    apply(
        new UnAssignNamespaceUMLFromStateVariablesVersionEvent(
            command.getStateVariablesVersionId()));
  }

  @CommandHandler
  public void handle(AssignShortNameToStateVariablesVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignShortNameToStateVariablesVersionCommand");

    if (shortName != null
        && shortName.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "ShortName already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignShortNameToStateVariablesVersionEvent(
            command.getStateVariablesVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignShortNameFromStateVariablesVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignShortNameFromStateVariablesVersionCommand");

    if (shortName == null) throw new ProcessingException("ShortName already has nothing assigned.");

    apply(
        new UnAssignShortNameFromStateVariablesVersionEvent(command.getStateVariablesVersionId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateStateVariablesVersionEvent event) {
    LOGGER.info("Event sourcing CreateStateVariablesVersionEvent");
    this.stateVariablesVersionId = event.getStateVariablesVersionId();
  }

  @EventSourcingHandler
  void on(UpdateStateVariablesVersionEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.baseUML = event.getBaseUML();
    this.baseURI = event.getBaseURI();
    this.date = event.getDate();
    this.differenceModelURI = event.getDifferenceModelURI();
    this.entsoeUML = event.getEntsoeUML();
    this.entsoeURI = event.getEntsoeURI();
    this.modelDescriptionURI = event.getModelDescriptionURI();
    this.namespaceRDF = event.getNamespaceRDF();
    this.namespaceUML = event.getNamespaceUML();
    this.shortName = event.getShortName();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignBaseUMLToStateVariablesVersionEvent event) {
    LOGGER.info("Event sourcing AssignBaseUMLToStateVariablesVersionEvent");
    this.baseUML = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBaseUMLFromStateVariablesVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignBaseUMLFromStateVariablesVersionEvent");
    this.baseUML = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignBaseURIToStateVariablesVersionEvent event) {
    LOGGER.info("Event sourcing AssignBaseURIToStateVariablesVersionEvent");
    this.baseURI = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBaseURIFromStateVariablesVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignBaseURIFromStateVariablesVersionEvent");
    this.baseURI = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDateToStateVariablesVersionEvent event) {
    LOGGER.info("Event sourcing AssignDateToStateVariablesVersionEvent");
    this.date = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDateFromStateVariablesVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignDateFromStateVariablesVersionEvent");
    this.date = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDifferenceModelURIToStateVariablesVersionEvent event) {
    LOGGER.info("Event sourcing AssignDifferenceModelURIToStateVariablesVersionEvent");
    this.differenceModelURI = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDifferenceModelURIFromStateVariablesVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignDifferenceModelURIFromStateVariablesVersionEvent");
    this.differenceModelURI = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEntsoeUMLToStateVariablesVersionEvent event) {
    LOGGER.info("Event sourcing AssignEntsoeUMLToStateVariablesVersionEvent");
    this.entsoeUML = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEntsoeUMLFromStateVariablesVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignEntsoeUMLFromStateVariablesVersionEvent");
    this.entsoeUML = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEntsoeURIToStateVariablesVersionEvent event) {
    LOGGER.info("Event sourcing AssignEntsoeURIToStateVariablesVersionEvent");
    this.entsoeURI = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEntsoeURIFromStateVariablesVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignEntsoeURIFromStateVariablesVersionEvent");
    this.entsoeURI = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignModelDescriptionURIToStateVariablesVersionEvent event) {
    LOGGER.info("Event sourcing AssignModelDescriptionURIToStateVariablesVersionEvent");
    this.modelDescriptionURI = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignModelDescriptionURIFromStateVariablesVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignModelDescriptionURIFromStateVariablesVersionEvent");
    this.modelDescriptionURI = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignNamespaceRDFToStateVariablesVersionEvent event) {
    LOGGER.info("Event sourcing AssignNamespaceRDFToStateVariablesVersionEvent");
    this.namespaceRDF = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNamespaceRDFFromStateVariablesVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignNamespaceRDFFromStateVariablesVersionEvent");
    this.namespaceRDF = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignNamespaceUMLToStateVariablesVersionEvent event) {
    LOGGER.info("Event sourcing AssignNamespaceUMLToStateVariablesVersionEvent");
    this.namespaceUML = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNamespaceUMLFromStateVariablesVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignNamespaceUMLFromStateVariablesVersionEvent");
    this.namespaceUML = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignShortNameToStateVariablesVersionEvent event) {
    LOGGER.info("Event sourcing AssignShortNameToStateVariablesVersionEvent");
    this.shortName = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignShortNameFromStateVariablesVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignShortNameFromStateVariablesVersionEvent");
    this.shortName = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID stateVariablesVersionId;

  private StringProxy baseUML = null;
  private StringProxy baseURI = null;
  private DateProxy date = null;
  private StringProxy differenceModelURI = null;
  private StringProxy entsoeUML = null;
  private StringProxy entsoeURI = null;
  private StringProxy modelDescriptionURI = null;
  private StringProxy namespaceRDF = null;
  private StringProxy namespaceUML = null;
  private StringProxy shortName = null;

  private static final Logger LOGGER =
      Logger.getLogger(StateVariablesVersionAggregate.class.getName());
}
