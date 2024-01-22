package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.aggregate;

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
 * Aggregate handler for EquipmentVersion as outlined for the CQRS pattern, all write
 * responsibilities related to EquipmentVersion are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class EquipmentVersionAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public EquipmentVersionAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public EquipmentVersionAggregate(CreateEquipmentVersionCommand command) throws Exception {
    LOGGER.info("Handling command CreateEquipmentVersionCommand");
    CreateEquipmentVersionEvent event =
        new CreateEquipmentVersionEvent(command.getEquipmentVersionId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateEquipmentVersionCommand command) throws Exception {
    LOGGER.info("handling command UpdateEquipmentVersionCommand");
    UpdateEquipmentVersionEvent event =
        new UpdateEquipmentVersionEvent(
            command.getEquipmentVersionId(),
            command.getBaseUML(),
            command.getBaseURIcore(),
            command.getBaseURIoperation(),
            command.getBaseURIshortCircuit(),
            command.getDate(),
            command.getDifferenceModelURI(),
            command.getEntsoeUML(),
            command.getEntsoeURIcore(),
            command.getEntsoeURIoperation(),
            command.getEntsoeURIshortCircuit(),
            command.getModelDescriptionURI(),
            command.getNamespaceRDF(),
            command.getNamespaceUML(),
            command.getShortName());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteEquipmentVersionCommand command) throws Exception {
    LOGGER.info("Handling command DeleteEquipmentVersionCommand");
    apply(new DeleteEquipmentVersionEvent(command.getEquipmentVersionId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignBaseUMLToEquipmentVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignBaseUMLToEquipmentVersionCommand");

    if (baseUML != null && baseUML.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "BaseUML already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignBaseUMLToEquipmentVersionEvent(
            command.getEquipmentVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBaseUMLFromEquipmentVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignBaseUMLFromEquipmentVersionCommand");

    if (baseUML == null) throw new ProcessingException("BaseUML already has nothing assigned.");

    apply(new UnAssignBaseUMLFromEquipmentVersionEvent(command.getEquipmentVersionId()));
  }

  @CommandHandler
  public void handle(AssignBaseURIcoreToEquipmentVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignBaseURIcoreToEquipmentVersionCommand");

    if (baseURIcore != null
        && baseURIcore.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "BaseURIcore already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignBaseURIcoreToEquipmentVersionEvent(
            command.getEquipmentVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBaseURIcoreFromEquipmentVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignBaseURIcoreFromEquipmentVersionCommand");

    if (baseURIcore == null)
      throw new ProcessingException("BaseURIcore already has nothing assigned.");

    apply(new UnAssignBaseURIcoreFromEquipmentVersionEvent(command.getEquipmentVersionId()));
  }

  @CommandHandler
  public void handle(AssignBaseURIoperationToEquipmentVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignBaseURIoperationToEquipmentVersionCommand");

    if (baseURIoperation != null
        && baseURIoperation.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "BaseURIoperation already assigned with id "
              + command.getAssignment().getStringProxyId());

    apply(
        new AssignBaseURIoperationToEquipmentVersionEvent(
            command.getEquipmentVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBaseURIoperationFromEquipmentVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignBaseURIoperationFromEquipmentVersionCommand");

    if (baseURIoperation == null)
      throw new ProcessingException("BaseURIoperation already has nothing assigned.");

    apply(new UnAssignBaseURIoperationFromEquipmentVersionEvent(command.getEquipmentVersionId()));
  }

  @CommandHandler
  public void handle(AssignBaseURIshortCircuitToEquipmentVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignBaseURIshortCircuitToEquipmentVersionCommand");

    if (baseURIshortCircuit != null
        && baseURIshortCircuit.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "BaseURIshortCircuit already assigned with id "
              + command.getAssignment().getStringProxyId());

    apply(
        new AssignBaseURIshortCircuitToEquipmentVersionEvent(
            command.getEquipmentVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBaseURIshortCircuitFromEquipmentVersionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignBaseURIshortCircuitFromEquipmentVersionCommand");

    if (baseURIshortCircuit == null)
      throw new ProcessingException("BaseURIshortCircuit already has nothing assigned.");

    apply(
        new UnAssignBaseURIshortCircuitFromEquipmentVersionEvent(command.getEquipmentVersionId()));
  }

  @CommandHandler
  public void handle(AssignDateToEquipmentVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignDateToEquipmentVersionCommand");

    if (date != null && date.getDateProxyId() == command.getAssignment().getDateProxyId())
      throw new ProcessingException(
          "Date already assigned with id " + command.getAssignment().getDateProxyId());

    apply(
        new AssignDateToEquipmentVersionEvent(
            command.getEquipmentVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDateFromEquipmentVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDateFromEquipmentVersionCommand");

    if (date == null) throw new ProcessingException("Date already has nothing assigned.");

    apply(new UnAssignDateFromEquipmentVersionEvent(command.getEquipmentVersionId()));
  }

  @CommandHandler
  public void handle(AssignDifferenceModelURIToEquipmentVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignDifferenceModelURIToEquipmentVersionCommand");

    if (differenceModelURI != null
        && differenceModelURI.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "DifferenceModelURI already assigned with id "
              + command.getAssignment().getStringProxyId());

    apply(
        new AssignDifferenceModelURIToEquipmentVersionEvent(
            command.getEquipmentVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDifferenceModelURIFromEquipmentVersionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignDifferenceModelURIFromEquipmentVersionCommand");

    if (differenceModelURI == null)
      throw new ProcessingException("DifferenceModelURI already has nothing assigned.");

    apply(new UnAssignDifferenceModelURIFromEquipmentVersionEvent(command.getEquipmentVersionId()));
  }

  @CommandHandler
  public void handle(AssignEntsoeUMLToEquipmentVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignEntsoeUMLToEquipmentVersionCommand");

    if (entsoeUML != null
        && entsoeUML.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "EntsoeUML already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignEntsoeUMLToEquipmentVersionEvent(
            command.getEquipmentVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEntsoeUMLFromEquipmentVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEntsoeUMLFromEquipmentVersionCommand");

    if (entsoeUML == null) throw new ProcessingException("EntsoeUML already has nothing assigned.");

    apply(new UnAssignEntsoeUMLFromEquipmentVersionEvent(command.getEquipmentVersionId()));
  }

  @CommandHandler
  public void handle(AssignEntsoeURIcoreToEquipmentVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignEntsoeURIcoreToEquipmentVersionCommand");

    if (entsoeURIcore != null
        && entsoeURIcore.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "EntsoeURIcore already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignEntsoeURIcoreToEquipmentVersionEvent(
            command.getEquipmentVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEntsoeURIcoreFromEquipmentVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEntsoeURIcoreFromEquipmentVersionCommand");

    if (entsoeURIcore == null)
      throw new ProcessingException("EntsoeURIcore already has nothing assigned.");

    apply(new UnAssignEntsoeURIcoreFromEquipmentVersionEvent(command.getEquipmentVersionId()));
  }

  @CommandHandler
  public void handle(AssignEntsoeURIoperationToEquipmentVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignEntsoeURIoperationToEquipmentVersionCommand");

    if (entsoeURIoperation != null
        && entsoeURIoperation.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "EntsoeURIoperation already assigned with id "
              + command.getAssignment().getStringProxyId());

    apply(
        new AssignEntsoeURIoperationToEquipmentVersionEvent(
            command.getEquipmentVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEntsoeURIoperationFromEquipmentVersionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignEntsoeURIoperationFromEquipmentVersionCommand");

    if (entsoeURIoperation == null)
      throw new ProcessingException("EntsoeURIoperation already has nothing assigned.");

    apply(new UnAssignEntsoeURIoperationFromEquipmentVersionEvent(command.getEquipmentVersionId()));
  }

  @CommandHandler
  public void handle(AssignEntsoeURIshortCircuitToEquipmentVersionCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignEntsoeURIshortCircuitToEquipmentVersionCommand");

    if (entsoeURIshortCircuit != null
        && entsoeURIshortCircuit.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "EntsoeURIshortCircuit already assigned with id "
              + command.getAssignment().getStringProxyId());

    apply(
        new AssignEntsoeURIshortCircuitToEquipmentVersionEvent(
            command.getEquipmentVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEntsoeURIshortCircuitFromEquipmentVersionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignEntsoeURIshortCircuitFromEquipmentVersionCommand");

    if (entsoeURIshortCircuit == null)
      throw new ProcessingException("EntsoeURIshortCircuit already has nothing assigned.");

    apply(
        new UnAssignEntsoeURIshortCircuitFromEquipmentVersionEvent(
            command.getEquipmentVersionId()));
  }

  @CommandHandler
  public void handle(AssignModelDescriptionURIToEquipmentVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignModelDescriptionURIToEquipmentVersionCommand");

    if (modelDescriptionURI != null
        && modelDescriptionURI.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "ModelDescriptionURI already assigned with id "
              + command.getAssignment().getStringProxyId());

    apply(
        new AssignModelDescriptionURIToEquipmentVersionEvent(
            command.getEquipmentVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignModelDescriptionURIFromEquipmentVersionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignModelDescriptionURIFromEquipmentVersionCommand");

    if (modelDescriptionURI == null)
      throw new ProcessingException("ModelDescriptionURI already has nothing assigned.");

    apply(
        new UnAssignModelDescriptionURIFromEquipmentVersionEvent(command.getEquipmentVersionId()));
  }

  @CommandHandler
  public void handle(AssignNamespaceRDFToEquipmentVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignNamespaceRDFToEquipmentVersionCommand");

    if (namespaceRDF != null
        && namespaceRDF.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "NamespaceRDF already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignNamespaceRDFToEquipmentVersionEvent(
            command.getEquipmentVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNamespaceRDFFromEquipmentVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignNamespaceRDFFromEquipmentVersionCommand");

    if (namespaceRDF == null)
      throw new ProcessingException("NamespaceRDF already has nothing assigned.");

    apply(new UnAssignNamespaceRDFFromEquipmentVersionEvent(command.getEquipmentVersionId()));
  }

  @CommandHandler
  public void handle(AssignNamespaceUMLToEquipmentVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignNamespaceUMLToEquipmentVersionCommand");

    if (namespaceUML != null
        && namespaceUML.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "NamespaceUML already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignNamespaceUMLToEquipmentVersionEvent(
            command.getEquipmentVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNamespaceUMLFromEquipmentVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignNamespaceUMLFromEquipmentVersionCommand");

    if (namespaceUML == null)
      throw new ProcessingException("NamespaceUML already has nothing assigned.");

    apply(new UnAssignNamespaceUMLFromEquipmentVersionEvent(command.getEquipmentVersionId()));
  }

  @CommandHandler
  public void handle(AssignShortNameToEquipmentVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignShortNameToEquipmentVersionCommand");

    if (shortName != null
        && shortName.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "ShortName already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignShortNameToEquipmentVersionEvent(
            command.getEquipmentVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignShortNameFromEquipmentVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignShortNameFromEquipmentVersionCommand");

    if (shortName == null) throw new ProcessingException("ShortName already has nothing assigned.");

    apply(new UnAssignShortNameFromEquipmentVersionEvent(command.getEquipmentVersionId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateEquipmentVersionEvent event) {
    LOGGER.info("Event sourcing CreateEquipmentVersionEvent");
    this.equipmentVersionId = event.getEquipmentVersionId();
  }

  @EventSourcingHandler
  void on(UpdateEquipmentVersionEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.baseUML = event.getBaseUML();
    this.baseURIcore = event.getBaseURIcore();
    this.baseURIoperation = event.getBaseURIoperation();
    this.baseURIshortCircuit = event.getBaseURIshortCircuit();
    this.date = event.getDate();
    this.differenceModelURI = event.getDifferenceModelURI();
    this.entsoeUML = event.getEntsoeUML();
    this.entsoeURIcore = event.getEntsoeURIcore();
    this.entsoeURIoperation = event.getEntsoeURIoperation();
    this.entsoeURIshortCircuit = event.getEntsoeURIshortCircuit();
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
  void on(AssignBaseUMLToEquipmentVersionEvent event) {
    LOGGER.info("Event sourcing AssignBaseUMLToEquipmentVersionEvent");
    this.baseUML = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBaseUMLFromEquipmentVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignBaseUMLFromEquipmentVersionEvent");
    this.baseUML = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignBaseURIcoreToEquipmentVersionEvent event) {
    LOGGER.info("Event sourcing AssignBaseURIcoreToEquipmentVersionEvent");
    this.baseURIcore = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBaseURIcoreFromEquipmentVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignBaseURIcoreFromEquipmentVersionEvent");
    this.baseURIcore = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignBaseURIoperationToEquipmentVersionEvent event) {
    LOGGER.info("Event sourcing AssignBaseURIoperationToEquipmentVersionEvent");
    this.baseURIoperation = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBaseURIoperationFromEquipmentVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignBaseURIoperationFromEquipmentVersionEvent");
    this.baseURIoperation = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignBaseURIshortCircuitToEquipmentVersionEvent event) {
    LOGGER.info("Event sourcing AssignBaseURIshortCircuitToEquipmentVersionEvent");
    this.baseURIshortCircuit = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBaseURIshortCircuitFromEquipmentVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignBaseURIshortCircuitFromEquipmentVersionEvent");
    this.baseURIshortCircuit = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDateToEquipmentVersionEvent event) {
    LOGGER.info("Event sourcing AssignDateToEquipmentVersionEvent");
    this.date = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDateFromEquipmentVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignDateFromEquipmentVersionEvent");
    this.date = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDifferenceModelURIToEquipmentVersionEvent event) {
    LOGGER.info("Event sourcing AssignDifferenceModelURIToEquipmentVersionEvent");
    this.differenceModelURI = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDifferenceModelURIFromEquipmentVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignDifferenceModelURIFromEquipmentVersionEvent");
    this.differenceModelURI = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEntsoeUMLToEquipmentVersionEvent event) {
    LOGGER.info("Event sourcing AssignEntsoeUMLToEquipmentVersionEvent");
    this.entsoeUML = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEntsoeUMLFromEquipmentVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignEntsoeUMLFromEquipmentVersionEvent");
    this.entsoeUML = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEntsoeURIcoreToEquipmentVersionEvent event) {
    LOGGER.info("Event sourcing AssignEntsoeURIcoreToEquipmentVersionEvent");
    this.entsoeURIcore = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEntsoeURIcoreFromEquipmentVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignEntsoeURIcoreFromEquipmentVersionEvent");
    this.entsoeURIcore = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEntsoeURIoperationToEquipmentVersionEvent event) {
    LOGGER.info("Event sourcing AssignEntsoeURIoperationToEquipmentVersionEvent");
    this.entsoeURIoperation = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEntsoeURIoperationFromEquipmentVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignEntsoeURIoperationFromEquipmentVersionEvent");
    this.entsoeURIoperation = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEntsoeURIshortCircuitToEquipmentVersionEvent event) {
    LOGGER.info("Event sourcing AssignEntsoeURIshortCircuitToEquipmentVersionEvent");
    this.entsoeURIshortCircuit = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEntsoeURIshortCircuitFromEquipmentVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignEntsoeURIshortCircuitFromEquipmentVersionEvent");
    this.entsoeURIshortCircuit = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignModelDescriptionURIToEquipmentVersionEvent event) {
    LOGGER.info("Event sourcing AssignModelDescriptionURIToEquipmentVersionEvent");
    this.modelDescriptionURI = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignModelDescriptionURIFromEquipmentVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignModelDescriptionURIFromEquipmentVersionEvent");
    this.modelDescriptionURI = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignNamespaceRDFToEquipmentVersionEvent event) {
    LOGGER.info("Event sourcing AssignNamespaceRDFToEquipmentVersionEvent");
    this.namespaceRDF = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNamespaceRDFFromEquipmentVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignNamespaceRDFFromEquipmentVersionEvent");
    this.namespaceRDF = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignNamespaceUMLToEquipmentVersionEvent event) {
    LOGGER.info("Event sourcing AssignNamespaceUMLToEquipmentVersionEvent");
    this.namespaceUML = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNamespaceUMLFromEquipmentVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignNamespaceUMLFromEquipmentVersionEvent");
    this.namespaceUML = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignShortNameToEquipmentVersionEvent event) {
    LOGGER.info("Event sourcing AssignShortNameToEquipmentVersionEvent");
    this.shortName = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignShortNameFromEquipmentVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignShortNameFromEquipmentVersionEvent");
    this.shortName = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID equipmentVersionId;

  private StringProxy baseUML = null;
  private StringProxy baseURIcore = null;
  private StringProxy baseURIoperation = null;
  private StringProxy baseURIshortCircuit = null;
  private DateProxy date = null;
  private StringProxy differenceModelURI = null;
  private StringProxy entsoeUML = null;
  private StringProxy entsoeURIcore = null;
  private StringProxy entsoeURIoperation = null;
  private StringProxy entsoeURIshortCircuit = null;
  private StringProxy modelDescriptionURI = null;
  private StringProxy namespaceRDF = null;
  private StringProxy namespaceUML = null;
  private StringProxy shortName = null;

  private static final Logger LOGGER = Logger.getLogger(EquipmentVersionAggregate.class.getName());
}
