package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.aggregate;

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
 * Aggregate handler for DynamicsVersion as outlined for the CQRS pattern, all write
 * responsibilities related to DynamicsVersion are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class DynamicsVersionAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public DynamicsVersionAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public DynamicsVersionAggregate(CreateDynamicsVersionCommand command) throws Exception {
    LOGGER.info("Handling command CreateDynamicsVersionCommand");
    CreateDynamicsVersionEvent event =
        new CreateDynamicsVersionEvent(command.getDynamicsVersionId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateDynamicsVersionCommand command) throws Exception {
    LOGGER.info("handling command UpdateDynamicsVersionCommand");
    UpdateDynamicsVersionEvent event =
        new UpdateDynamicsVersionEvent(
            command.getDynamicsVersionId(),
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
  public void handle(DeleteDynamicsVersionCommand command) throws Exception {
    LOGGER.info("Handling command DeleteDynamicsVersionCommand");
    apply(new DeleteDynamicsVersionEvent(command.getDynamicsVersionId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignBaseUMLToDynamicsVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignBaseUMLToDynamicsVersionCommand");

    if (baseUML != null && baseUML.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "BaseUML already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignBaseUMLToDynamicsVersionEvent(
            command.getDynamicsVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBaseUMLFromDynamicsVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignBaseUMLFromDynamicsVersionCommand");

    if (baseUML == null) throw new ProcessingException("BaseUML already has nothing assigned.");

    apply(new UnAssignBaseUMLFromDynamicsVersionEvent(command.getDynamicsVersionId()));
  }

  @CommandHandler
  public void handle(AssignBaseURIToDynamicsVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignBaseURIToDynamicsVersionCommand");

    if (baseURI != null && baseURI.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "BaseURI already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignBaseURIToDynamicsVersionEvent(
            command.getDynamicsVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBaseURIFromDynamicsVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignBaseURIFromDynamicsVersionCommand");

    if (baseURI == null) throw new ProcessingException("BaseURI already has nothing assigned.");

    apply(new UnAssignBaseURIFromDynamicsVersionEvent(command.getDynamicsVersionId()));
  }

  @CommandHandler
  public void handle(AssignDateToDynamicsVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignDateToDynamicsVersionCommand");

    if (date != null && date.getDateProxyId() == command.getAssignment().getDateProxyId())
      throw new ProcessingException(
          "Date already assigned with id " + command.getAssignment().getDateProxyId());

    apply(
        new AssignDateToDynamicsVersionEvent(
            command.getDynamicsVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDateFromDynamicsVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDateFromDynamicsVersionCommand");

    if (date == null) throw new ProcessingException("Date already has nothing assigned.");

    apply(new UnAssignDateFromDynamicsVersionEvent(command.getDynamicsVersionId()));
  }

  @CommandHandler
  public void handle(AssignDifferenceModelURIToDynamicsVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignDifferenceModelURIToDynamicsVersionCommand");

    if (differenceModelURI != null
        && differenceModelURI.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "DifferenceModelURI already assigned with id "
              + command.getAssignment().getStringProxyId());

    apply(
        new AssignDifferenceModelURIToDynamicsVersionEvent(
            command.getDynamicsVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDifferenceModelURIFromDynamicsVersionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignDifferenceModelURIFromDynamicsVersionCommand");

    if (differenceModelURI == null)
      throw new ProcessingException("DifferenceModelURI already has nothing assigned.");

    apply(new UnAssignDifferenceModelURIFromDynamicsVersionEvent(command.getDynamicsVersionId()));
  }

  @CommandHandler
  public void handle(AssignEntsoeUMLToDynamicsVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignEntsoeUMLToDynamicsVersionCommand");

    if (entsoeUML != null
        && entsoeUML.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "EntsoeUML already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignEntsoeUMLToDynamicsVersionEvent(
            command.getDynamicsVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEntsoeUMLFromDynamicsVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEntsoeUMLFromDynamicsVersionCommand");

    if (entsoeUML == null) throw new ProcessingException("EntsoeUML already has nothing assigned.");

    apply(new UnAssignEntsoeUMLFromDynamicsVersionEvent(command.getDynamicsVersionId()));
  }

  @CommandHandler
  public void handle(AssignEntsoeURIToDynamicsVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignEntsoeURIToDynamicsVersionCommand");

    if (entsoeURI != null
        && entsoeURI.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "EntsoeURI already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignEntsoeURIToDynamicsVersionEvent(
            command.getDynamicsVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEntsoeURIFromDynamicsVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEntsoeURIFromDynamicsVersionCommand");

    if (entsoeURI == null) throw new ProcessingException("EntsoeURI already has nothing assigned.");

    apply(new UnAssignEntsoeURIFromDynamicsVersionEvent(command.getDynamicsVersionId()));
  }

  @CommandHandler
  public void handle(AssignModelDescriptionURIToDynamicsVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignModelDescriptionURIToDynamicsVersionCommand");

    if (modelDescriptionURI != null
        && modelDescriptionURI.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "ModelDescriptionURI already assigned with id "
              + command.getAssignment().getStringProxyId());

    apply(
        new AssignModelDescriptionURIToDynamicsVersionEvent(
            command.getDynamicsVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignModelDescriptionURIFromDynamicsVersionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignModelDescriptionURIFromDynamicsVersionCommand");

    if (modelDescriptionURI == null)
      throw new ProcessingException("ModelDescriptionURI already has nothing assigned.");

    apply(new UnAssignModelDescriptionURIFromDynamicsVersionEvent(command.getDynamicsVersionId()));
  }

  @CommandHandler
  public void handle(AssignNamespaceRDFToDynamicsVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignNamespaceRDFToDynamicsVersionCommand");

    if (namespaceRDF != null
        && namespaceRDF.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "NamespaceRDF already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignNamespaceRDFToDynamicsVersionEvent(
            command.getDynamicsVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNamespaceRDFFromDynamicsVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignNamespaceRDFFromDynamicsVersionCommand");

    if (namespaceRDF == null)
      throw new ProcessingException("NamespaceRDF already has nothing assigned.");

    apply(new UnAssignNamespaceRDFFromDynamicsVersionEvent(command.getDynamicsVersionId()));
  }

  @CommandHandler
  public void handle(AssignNamespaceUMLToDynamicsVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignNamespaceUMLToDynamicsVersionCommand");

    if (namespaceUML != null
        && namespaceUML.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "NamespaceUML already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignNamespaceUMLToDynamicsVersionEvent(
            command.getDynamicsVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNamespaceUMLFromDynamicsVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignNamespaceUMLFromDynamicsVersionCommand");

    if (namespaceUML == null)
      throw new ProcessingException("NamespaceUML already has nothing assigned.");

    apply(new UnAssignNamespaceUMLFromDynamicsVersionEvent(command.getDynamicsVersionId()));
  }

  @CommandHandler
  public void handle(AssignShortNameToDynamicsVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignShortNameToDynamicsVersionCommand");

    if (shortName != null
        && shortName.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "ShortName already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignShortNameToDynamicsVersionEvent(
            command.getDynamicsVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignShortNameFromDynamicsVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignShortNameFromDynamicsVersionCommand");

    if (shortName == null) throw new ProcessingException("ShortName already has nothing assigned.");

    apply(new UnAssignShortNameFromDynamicsVersionEvent(command.getDynamicsVersionId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateDynamicsVersionEvent event) {
    LOGGER.info("Event sourcing CreateDynamicsVersionEvent");
    this.dynamicsVersionId = event.getDynamicsVersionId();
  }

  @EventSourcingHandler
  void on(UpdateDynamicsVersionEvent event) {
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
  void on(AssignBaseUMLToDynamicsVersionEvent event) {
    LOGGER.info("Event sourcing AssignBaseUMLToDynamicsVersionEvent");
    this.baseUML = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBaseUMLFromDynamicsVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignBaseUMLFromDynamicsVersionEvent");
    this.baseUML = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignBaseURIToDynamicsVersionEvent event) {
    LOGGER.info("Event sourcing AssignBaseURIToDynamicsVersionEvent");
    this.baseURI = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBaseURIFromDynamicsVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignBaseURIFromDynamicsVersionEvent");
    this.baseURI = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDateToDynamicsVersionEvent event) {
    LOGGER.info("Event sourcing AssignDateToDynamicsVersionEvent");
    this.date = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDateFromDynamicsVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignDateFromDynamicsVersionEvent");
    this.date = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDifferenceModelURIToDynamicsVersionEvent event) {
    LOGGER.info("Event sourcing AssignDifferenceModelURIToDynamicsVersionEvent");
    this.differenceModelURI = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDifferenceModelURIFromDynamicsVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignDifferenceModelURIFromDynamicsVersionEvent");
    this.differenceModelURI = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEntsoeUMLToDynamicsVersionEvent event) {
    LOGGER.info("Event sourcing AssignEntsoeUMLToDynamicsVersionEvent");
    this.entsoeUML = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEntsoeUMLFromDynamicsVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignEntsoeUMLFromDynamicsVersionEvent");
    this.entsoeUML = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEntsoeURIToDynamicsVersionEvent event) {
    LOGGER.info("Event sourcing AssignEntsoeURIToDynamicsVersionEvent");
    this.entsoeURI = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEntsoeURIFromDynamicsVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignEntsoeURIFromDynamicsVersionEvent");
    this.entsoeURI = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignModelDescriptionURIToDynamicsVersionEvent event) {
    LOGGER.info("Event sourcing AssignModelDescriptionURIToDynamicsVersionEvent");
    this.modelDescriptionURI = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignModelDescriptionURIFromDynamicsVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignModelDescriptionURIFromDynamicsVersionEvent");
    this.modelDescriptionURI = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignNamespaceRDFToDynamicsVersionEvent event) {
    LOGGER.info("Event sourcing AssignNamespaceRDFToDynamicsVersionEvent");
    this.namespaceRDF = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNamespaceRDFFromDynamicsVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignNamespaceRDFFromDynamicsVersionEvent");
    this.namespaceRDF = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignNamespaceUMLToDynamicsVersionEvent event) {
    LOGGER.info("Event sourcing AssignNamespaceUMLToDynamicsVersionEvent");
    this.namespaceUML = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNamespaceUMLFromDynamicsVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignNamespaceUMLFromDynamicsVersionEvent");
    this.namespaceUML = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignShortNameToDynamicsVersionEvent event) {
    LOGGER.info("Event sourcing AssignShortNameToDynamicsVersionEvent");
    this.shortName = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignShortNameFromDynamicsVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignShortNameFromDynamicsVersionEvent");
    this.shortName = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID dynamicsVersionId;

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

  private static final Logger LOGGER = Logger.getLogger(DynamicsVersionAggregate.class.getName());
}
