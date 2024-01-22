package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.aggregate;

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
 * Aggregate handler for EquipmentBoundaryVersion as outlined for the CQRS pattern, all write
 * responsibilities related to EquipmentBoundaryVersion are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class EquipmentBoundaryVersionAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public EquipmentBoundaryVersionAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public EquipmentBoundaryVersionAggregate(CreateEquipmentBoundaryVersionCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateEquipmentBoundaryVersionCommand");
    CreateEquipmentBoundaryVersionEvent event =
        new CreateEquipmentBoundaryVersionEvent(command.getEquipmentBoundaryVersionId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateEquipmentBoundaryVersionCommand command) throws Exception {
    LOGGER.info("handling command UpdateEquipmentBoundaryVersionCommand");
    UpdateEquipmentBoundaryVersionEvent event =
        new UpdateEquipmentBoundaryVersionEvent(
            command.getEquipmentBoundaryVersionId(),
            command.getBaseUML(),
            command.getBaseURI(),
            command.getDate(),
            command.getDifferenceModelURI(),
            command.getEntsoeUML(),
            command.getEntsoeURIcore(),
            command.getEntsoeURIoperation(),
            command.getModelDescriptionURI(),
            command.getNamespaceRDF(),
            command.getNamespaceUML(),
            command.getShortName());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteEquipmentBoundaryVersionCommand command) throws Exception {
    LOGGER.info("Handling command DeleteEquipmentBoundaryVersionCommand");
    apply(new DeleteEquipmentBoundaryVersionEvent(command.getEquipmentBoundaryVersionId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignBaseUMLToEquipmentBoundaryVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignBaseUMLToEquipmentBoundaryVersionCommand");

    if (baseUML != null && baseUML.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "BaseUML already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignBaseUMLToEquipmentBoundaryVersionEvent(
            command.getEquipmentBoundaryVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBaseUMLFromEquipmentBoundaryVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignBaseUMLFromEquipmentBoundaryVersionCommand");

    if (baseUML == null) throw new ProcessingException("BaseUML already has nothing assigned.");

    apply(
        new UnAssignBaseUMLFromEquipmentBoundaryVersionEvent(
            command.getEquipmentBoundaryVersionId()));
  }

  @CommandHandler
  public void handle(AssignBaseURIToEquipmentBoundaryVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignBaseURIToEquipmentBoundaryVersionCommand");

    if (baseURI != null && baseURI.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "BaseURI already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignBaseURIToEquipmentBoundaryVersionEvent(
            command.getEquipmentBoundaryVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBaseURIFromEquipmentBoundaryVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignBaseURIFromEquipmentBoundaryVersionCommand");

    if (baseURI == null) throw new ProcessingException("BaseURI already has nothing assigned.");

    apply(
        new UnAssignBaseURIFromEquipmentBoundaryVersionEvent(
            command.getEquipmentBoundaryVersionId()));
  }

  @CommandHandler
  public void handle(AssignDateToEquipmentBoundaryVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignDateToEquipmentBoundaryVersionCommand");

    if (date != null && date.getDateProxyId() == command.getAssignment().getDateProxyId())
      throw new ProcessingException(
          "Date already assigned with id " + command.getAssignment().getDateProxyId());

    apply(
        new AssignDateToEquipmentBoundaryVersionEvent(
            command.getEquipmentBoundaryVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDateFromEquipmentBoundaryVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDateFromEquipmentBoundaryVersionCommand");

    if (date == null) throw new ProcessingException("Date already has nothing assigned.");

    apply(
        new UnAssignDateFromEquipmentBoundaryVersionEvent(command.getEquipmentBoundaryVersionId()));
  }

  @CommandHandler
  public void handle(AssignDifferenceModelURIToEquipmentBoundaryVersionCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignDifferenceModelURIToEquipmentBoundaryVersionCommand");

    if (differenceModelURI != null
        && differenceModelURI.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "DifferenceModelURI already assigned with id "
              + command.getAssignment().getStringProxyId());

    apply(
        new AssignDifferenceModelURIToEquipmentBoundaryVersionEvent(
            command.getEquipmentBoundaryVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDifferenceModelURIFromEquipmentBoundaryVersionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignDifferenceModelURIFromEquipmentBoundaryVersionCommand");

    if (differenceModelURI == null)
      throw new ProcessingException("DifferenceModelURI already has nothing assigned.");

    apply(
        new UnAssignDifferenceModelURIFromEquipmentBoundaryVersionEvent(
            command.getEquipmentBoundaryVersionId()));
  }

  @CommandHandler
  public void handle(AssignEntsoeUMLToEquipmentBoundaryVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignEntsoeUMLToEquipmentBoundaryVersionCommand");

    if (entsoeUML != null
        && entsoeUML.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "EntsoeUML already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignEntsoeUMLToEquipmentBoundaryVersionEvent(
            command.getEquipmentBoundaryVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEntsoeUMLFromEquipmentBoundaryVersionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignEntsoeUMLFromEquipmentBoundaryVersionCommand");

    if (entsoeUML == null) throw new ProcessingException("EntsoeUML already has nothing assigned.");

    apply(
        new UnAssignEntsoeUMLFromEquipmentBoundaryVersionEvent(
            command.getEquipmentBoundaryVersionId()));
  }

  @CommandHandler
  public void handle(AssignEntsoeURIcoreToEquipmentBoundaryVersionCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignEntsoeURIcoreToEquipmentBoundaryVersionCommand");

    if (entsoeURIcore != null
        && entsoeURIcore.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "EntsoeURIcore already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignEntsoeURIcoreToEquipmentBoundaryVersionEvent(
            command.getEquipmentBoundaryVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEntsoeURIcoreFromEquipmentBoundaryVersionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignEntsoeURIcoreFromEquipmentBoundaryVersionCommand");

    if (entsoeURIcore == null)
      throw new ProcessingException("EntsoeURIcore already has nothing assigned.");

    apply(
        new UnAssignEntsoeURIcoreFromEquipmentBoundaryVersionEvent(
            command.getEquipmentBoundaryVersionId()));
  }

  @CommandHandler
  public void handle(AssignEntsoeURIoperationToEquipmentBoundaryVersionCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignEntsoeURIoperationToEquipmentBoundaryVersionCommand");

    if (entsoeURIoperation != null
        && entsoeURIoperation.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "EntsoeURIoperation already assigned with id "
              + command.getAssignment().getStringProxyId());

    apply(
        new AssignEntsoeURIoperationToEquipmentBoundaryVersionEvent(
            command.getEquipmentBoundaryVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEntsoeURIoperationFromEquipmentBoundaryVersionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignEntsoeURIoperationFromEquipmentBoundaryVersionCommand");

    if (entsoeURIoperation == null)
      throw new ProcessingException("EntsoeURIoperation already has nothing assigned.");

    apply(
        new UnAssignEntsoeURIoperationFromEquipmentBoundaryVersionEvent(
            command.getEquipmentBoundaryVersionId()));
  }

  @CommandHandler
  public void handle(AssignModelDescriptionURIToEquipmentBoundaryVersionCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignModelDescriptionURIToEquipmentBoundaryVersionCommand");

    if (modelDescriptionURI != null
        && modelDescriptionURI.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "ModelDescriptionURI already assigned with id "
              + command.getAssignment().getStringProxyId());

    apply(
        new AssignModelDescriptionURIToEquipmentBoundaryVersionEvent(
            command.getEquipmentBoundaryVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignModelDescriptionURIFromEquipmentBoundaryVersionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignModelDescriptionURIFromEquipmentBoundaryVersionCommand");

    if (modelDescriptionURI == null)
      throw new ProcessingException("ModelDescriptionURI already has nothing assigned.");

    apply(
        new UnAssignModelDescriptionURIFromEquipmentBoundaryVersionEvent(
            command.getEquipmentBoundaryVersionId()));
  }

  @CommandHandler
  public void handle(AssignNamespaceRDFToEquipmentBoundaryVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignNamespaceRDFToEquipmentBoundaryVersionCommand");

    if (namespaceRDF != null
        && namespaceRDF.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "NamespaceRDF already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignNamespaceRDFToEquipmentBoundaryVersionEvent(
            command.getEquipmentBoundaryVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNamespaceRDFFromEquipmentBoundaryVersionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignNamespaceRDFFromEquipmentBoundaryVersionCommand");

    if (namespaceRDF == null)
      throw new ProcessingException("NamespaceRDF already has nothing assigned.");

    apply(
        new UnAssignNamespaceRDFFromEquipmentBoundaryVersionEvent(
            command.getEquipmentBoundaryVersionId()));
  }

  @CommandHandler
  public void handle(AssignNamespaceUMLToEquipmentBoundaryVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignNamespaceUMLToEquipmentBoundaryVersionCommand");

    if (namespaceUML != null
        && namespaceUML.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "NamespaceUML already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignNamespaceUMLToEquipmentBoundaryVersionEvent(
            command.getEquipmentBoundaryVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNamespaceUMLFromEquipmentBoundaryVersionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignNamespaceUMLFromEquipmentBoundaryVersionCommand");

    if (namespaceUML == null)
      throw new ProcessingException("NamespaceUML already has nothing assigned.");

    apply(
        new UnAssignNamespaceUMLFromEquipmentBoundaryVersionEvent(
            command.getEquipmentBoundaryVersionId()));
  }

  @CommandHandler
  public void handle(AssignShortNameToEquipmentBoundaryVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignShortNameToEquipmentBoundaryVersionCommand");

    if (shortName != null
        && shortName.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "ShortName already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignShortNameToEquipmentBoundaryVersionEvent(
            command.getEquipmentBoundaryVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignShortNameFromEquipmentBoundaryVersionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignShortNameFromEquipmentBoundaryVersionCommand");

    if (shortName == null) throw new ProcessingException("ShortName already has nothing assigned.");

    apply(
        new UnAssignShortNameFromEquipmentBoundaryVersionEvent(
            command.getEquipmentBoundaryVersionId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateEquipmentBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing CreateEquipmentBoundaryVersionEvent");
    this.equipmentBoundaryVersionId = event.getEquipmentBoundaryVersionId();
  }

  @EventSourcingHandler
  void on(UpdateEquipmentBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.baseUML = event.getBaseUML();
    this.baseURI = event.getBaseURI();
    this.date = event.getDate();
    this.differenceModelURI = event.getDifferenceModelURI();
    this.entsoeUML = event.getEntsoeUML();
    this.entsoeURIcore = event.getEntsoeURIcore();
    this.entsoeURIoperation = event.getEntsoeURIoperation();
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
  void on(AssignBaseUMLToEquipmentBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing AssignBaseUMLToEquipmentBoundaryVersionEvent");
    this.baseUML = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBaseUMLFromEquipmentBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignBaseUMLFromEquipmentBoundaryVersionEvent");
    this.baseUML = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignBaseURIToEquipmentBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing AssignBaseURIToEquipmentBoundaryVersionEvent");
    this.baseURI = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBaseURIFromEquipmentBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignBaseURIFromEquipmentBoundaryVersionEvent");
    this.baseURI = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDateToEquipmentBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing AssignDateToEquipmentBoundaryVersionEvent");
    this.date = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDateFromEquipmentBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignDateFromEquipmentBoundaryVersionEvent");
    this.date = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDifferenceModelURIToEquipmentBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing AssignDifferenceModelURIToEquipmentBoundaryVersionEvent");
    this.differenceModelURI = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDifferenceModelURIFromEquipmentBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignDifferenceModelURIFromEquipmentBoundaryVersionEvent");
    this.differenceModelURI = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEntsoeUMLToEquipmentBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing AssignEntsoeUMLToEquipmentBoundaryVersionEvent");
    this.entsoeUML = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEntsoeUMLFromEquipmentBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignEntsoeUMLFromEquipmentBoundaryVersionEvent");
    this.entsoeUML = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEntsoeURIcoreToEquipmentBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing AssignEntsoeURIcoreToEquipmentBoundaryVersionEvent");
    this.entsoeURIcore = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEntsoeURIcoreFromEquipmentBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignEntsoeURIcoreFromEquipmentBoundaryVersionEvent");
    this.entsoeURIcore = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEntsoeURIoperationToEquipmentBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing AssignEntsoeURIoperationToEquipmentBoundaryVersionEvent");
    this.entsoeURIoperation = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEntsoeURIoperationFromEquipmentBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignEntsoeURIoperationFromEquipmentBoundaryVersionEvent");
    this.entsoeURIoperation = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignModelDescriptionURIToEquipmentBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing AssignModelDescriptionURIToEquipmentBoundaryVersionEvent");
    this.modelDescriptionURI = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignModelDescriptionURIFromEquipmentBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignModelDescriptionURIFromEquipmentBoundaryVersionEvent");
    this.modelDescriptionURI = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignNamespaceRDFToEquipmentBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing AssignNamespaceRDFToEquipmentBoundaryVersionEvent");
    this.namespaceRDF = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNamespaceRDFFromEquipmentBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignNamespaceRDFFromEquipmentBoundaryVersionEvent");
    this.namespaceRDF = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignNamespaceUMLToEquipmentBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing AssignNamespaceUMLToEquipmentBoundaryVersionEvent");
    this.namespaceUML = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNamespaceUMLFromEquipmentBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignNamespaceUMLFromEquipmentBoundaryVersionEvent");
    this.namespaceUML = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignShortNameToEquipmentBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing AssignShortNameToEquipmentBoundaryVersionEvent");
    this.shortName = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignShortNameFromEquipmentBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignShortNameFromEquipmentBoundaryVersionEvent");
    this.shortName = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID equipmentBoundaryVersionId;

  private StringProxy baseUML = null;
  private StringProxy baseURI = null;
  private DateProxy date = null;
  private StringProxy differenceModelURI = null;
  private StringProxy entsoeUML = null;
  private StringProxy entsoeURIcore = null;
  private StringProxy entsoeURIoperation = null;
  private StringProxy modelDescriptionURI = null;
  private StringProxy namespaceRDF = null;
  private StringProxy namespaceUML = null;
  private StringProxy shortName = null;

  private static final Logger LOGGER =
      Logger.getLogger(EquipmentBoundaryVersionAggregate.class.getName());
}
