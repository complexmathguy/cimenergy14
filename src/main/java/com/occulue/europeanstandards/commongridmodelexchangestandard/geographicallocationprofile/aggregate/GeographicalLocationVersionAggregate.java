package com.occulue.europeanstandards.commongridmodelexchangestandard.geographicallocationprofile.aggregate;

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
 * Aggregate handler for GeographicalLocationVersion as outlined for the CQRS pattern, all write
 * responsibilities related to GeographicalLocationVersion are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class GeographicalLocationVersionAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public GeographicalLocationVersionAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public GeographicalLocationVersionAggregate(CreateGeographicalLocationVersionCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateGeographicalLocationVersionCommand");
    CreateGeographicalLocationVersionEvent event =
        new CreateGeographicalLocationVersionEvent(command.getGeographicalLocationVersionId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateGeographicalLocationVersionCommand command) throws Exception {
    LOGGER.info("handling command UpdateGeographicalLocationVersionCommand");
    UpdateGeographicalLocationVersionEvent event =
        new UpdateGeographicalLocationVersionEvent(
            command.getGeographicalLocationVersionId(),
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
  public void handle(DeleteGeographicalLocationVersionCommand command) throws Exception {
    LOGGER.info("Handling command DeleteGeographicalLocationVersionCommand");
    apply(new DeleteGeographicalLocationVersionEvent(command.getGeographicalLocationVersionId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignBaseUMLToGeographicalLocationVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignBaseUMLToGeographicalLocationVersionCommand");

    if (baseUML != null && baseUML.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "BaseUML already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignBaseUMLToGeographicalLocationVersionEvent(
            command.getGeographicalLocationVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBaseUMLFromGeographicalLocationVersionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignBaseUMLFromGeographicalLocationVersionCommand");

    if (baseUML == null) throw new ProcessingException("BaseUML already has nothing assigned.");

    apply(
        new UnAssignBaseUMLFromGeographicalLocationVersionEvent(
            command.getGeographicalLocationVersionId()));
  }

  @CommandHandler
  public void handle(AssignBaseURIToGeographicalLocationVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignBaseURIToGeographicalLocationVersionCommand");

    if (baseURI != null && baseURI.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "BaseURI already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignBaseURIToGeographicalLocationVersionEvent(
            command.getGeographicalLocationVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBaseURIFromGeographicalLocationVersionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignBaseURIFromGeographicalLocationVersionCommand");

    if (baseURI == null) throw new ProcessingException("BaseURI already has nothing assigned.");

    apply(
        new UnAssignBaseURIFromGeographicalLocationVersionEvent(
            command.getGeographicalLocationVersionId()));
  }

  @CommandHandler
  public void handle(AssignDateToGeographicalLocationVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignDateToGeographicalLocationVersionCommand");

    if (date != null && date.getDateProxyId() == command.getAssignment().getDateProxyId())
      throw new ProcessingException(
          "Date already assigned with id " + command.getAssignment().getDateProxyId());

    apply(
        new AssignDateToGeographicalLocationVersionEvent(
            command.getGeographicalLocationVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDateFromGeographicalLocationVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDateFromGeographicalLocationVersionCommand");

    if (date == null) throw new ProcessingException("Date already has nothing assigned.");

    apply(
        new UnAssignDateFromGeographicalLocationVersionEvent(
            command.getGeographicalLocationVersionId()));
  }

  @CommandHandler
  public void handle(AssignDifferenceModelURIToGeographicalLocationVersionCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignDifferenceModelURIToGeographicalLocationVersionCommand");

    if (differenceModelURI != null
        && differenceModelURI.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "DifferenceModelURI already assigned with id "
              + command.getAssignment().getStringProxyId());

    apply(
        new AssignDifferenceModelURIToGeographicalLocationVersionEvent(
            command.getGeographicalLocationVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDifferenceModelURIFromGeographicalLocationVersionCommand command)
      throws Exception {
    LOGGER.info(
        "Handlign command UnAssignDifferenceModelURIFromGeographicalLocationVersionCommand");

    if (differenceModelURI == null)
      throw new ProcessingException("DifferenceModelURI already has nothing assigned.");

    apply(
        new UnAssignDifferenceModelURIFromGeographicalLocationVersionEvent(
            command.getGeographicalLocationVersionId()));
  }

  @CommandHandler
  public void handle(AssignEntsoeUMLToGeographicalLocationVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignEntsoeUMLToGeographicalLocationVersionCommand");

    if (entsoeUML != null
        && entsoeUML.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "EntsoeUML already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignEntsoeUMLToGeographicalLocationVersionEvent(
            command.getGeographicalLocationVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEntsoeUMLFromGeographicalLocationVersionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignEntsoeUMLFromGeographicalLocationVersionCommand");

    if (entsoeUML == null) throw new ProcessingException("EntsoeUML already has nothing assigned.");

    apply(
        new UnAssignEntsoeUMLFromGeographicalLocationVersionEvent(
            command.getGeographicalLocationVersionId()));
  }

  @CommandHandler
  public void handle(AssignEntsoeURIToGeographicalLocationVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignEntsoeURIToGeographicalLocationVersionCommand");

    if (entsoeURI != null
        && entsoeURI.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "EntsoeURI already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignEntsoeURIToGeographicalLocationVersionEvent(
            command.getGeographicalLocationVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEntsoeURIFromGeographicalLocationVersionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignEntsoeURIFromGeographicalLocationVersionCommand");

    if (entsoeURI == null) throw new ProcessingException("EntsoeURI already has nothing assigned.");

    apply(
        new UnAssignEntsoeURIFromGeographicalLocationVersionEvent(
            command.getGeographicalLocationVersionId()));
  }

  @CommandHandler
  public void handle(AssignModelDescriptionURIToGeographicalLocationVersionCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignModelDescriptionURIToGeographicalLocationVersionCommand");

    if (modelDescriptionURI != null
        && modelDescriptionURI.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "ModelDescriptionURI already assigned with id "
              + command.getAssignment().getStringProxyId());

    apply(
        new AssignModelDescriptionURIToGeographicalLocationVersionEvent(
            command.getGeographicalLocationVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignModelDescriptionURIFromGeographicalLocationVersionCommand command)
      throws Exception {
    LOGGER.info(
        "Handlign command UnAssignModelDescriptionURIFromGeographicalLocationVersionCommand");

    if (modelDescriptionURI == null)
      throw new ProcessingException("ModelDescriptionURI already has nothing assigned.");

    apply(
        new UnAssignModelDescriptionURIFromGeographicalLocationVersionEvent(
            command.getGeographicalLocationVersionId()));
  }

  @CommandHandler
  public void handle(AssignNamespaceRDFToGeographicalLocationVersionCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignNamespaceRDFToGeographicalLocationVersionCommand");

    if (namespaceRDF != null
        && namespaceRDF.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "NamespaceRDF already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignNamespaceRDFToGeographicalLocationVersionEvent(
            command.getGeographicalLocationVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNamespaceRDFFromGeographicalLocationVersionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignNamespaceRDFFromGeographicalLocationVersionCommand");

    if (namespaceRDF == null)
      throw new ProcessingException("NamespaceRDF already has nothing assigned.");

    apply(
        new UnAssignNamespaceRDFFromGeographicalLocationVersionEvent(
            command.getGeographicalLocationVersionId()));
  }

  @CommandHandler
  public void handle(AssignNamespaceUMLToGeographicalLocationVersionCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignNamespaceUMLToGeographicalLocationVersionCommand");

    if (namespaceUML != null
        && namespaceUML.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "NamespaceUML already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignNamespaceUMLToGeographicalLocationVersionEvent(
            command.getGeographicalLocationVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNamespaceUMLFromGeographicalLocationVersionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignNamespaceUMLFromGeographicalLocationVersionCommand");

    if (namespaceUML == null)
      throw new ProcessingException("NamespaceUML already has nothing assigned.");

    apply(
        new UnAssignNamespaceUMLFromGeographicalLocationVersionEvent(
            command.getGeographicalLocationVersionId()));
  }

  @CommandHandler
  public void handle(AssignShortNameToGeographicalLocationVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignShortNameToGeographicalLocationVersionCommand");

    if (shortName != null
        && shortName.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "ShortName already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignShortNameToGeographicalLocationVersionEvent(
            command.getGeographicalLocationVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignShortNameFromGeographicalLocationVersionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignShortNameFromGeographicalLocationVersionCommand");

    if (shortName == null) throw new ProcessingException("ShortName already has nothing assigned.");

    apply(
        new UnAssignShortNameFromGeographicalLocationVersionEvent(
            command.getGeographicalLocationVersionId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateGeographicalLocationVersionEvent event) {
    LOGGER.info("Event sourcing CreateGeographicalLocationVersionEvent");
    this.geographicalLocationVersionId = event.getGeographicalLocationVersionId();
  }

  @EventSourcingHandler
  void on(UpdateGeographicalLocationVersionEvent event) {
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
  void on(AssignBaseUMLToGeographicalLocationVersionEvent event) {
    LOGGER.info("Event sourcing AssignBaseUMLToGeographicalLocationVersionEvent");
    this.baseUML = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBaseUMLFromGeographicalLocationVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignBaseUMLFromGeographicalLocationVersionEvent");
    this.baseUML = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignBaseURIToGeographicalLocationVersionEvent event) {
    LOGGER.info("Event sourcing AssignBaseURIToGeographicalLocationVersionEvent");
    this.baseURI = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBaseURIFromGeographicalLocationVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignBaseURIFromGeographicalLocationVersionEvent");
    this.baseURI = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDateToGeographicalLocationVersionEvent event) {
    LOGGER.info("Event sourcing AssignDateToGeographicalLocationVersionEvent");
    this.date = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDateFromGeographicalLocationVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignDateFromGeographicalLocationVersionEvent");
    this.date = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDifferenceModelURIToGeographicalLocationVersionEvent event) {
    LOGGER.info("Event sourcing AssignDifferenceModelURIToGeographicalLocationVersionEvent");
    this.differenceModelURI = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDifferenceModelURIFromGeographicalLocationVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignDifferenceModelURIFromGeographicalLocationVersionEvent");
    this.differenceModelURI = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEntsoeUMLToGeographicalLocationVersionEvent event) {
    LOGGER.info("Event sourcing AssignEntsoeUMLToGeographicalLocationVersionEvent");
    this.entsoeUML = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEntsoeUMLFromGeographicalLocationVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignEntsoeUMLFromGeographicalLocationVersionEvent");
    this.entsoeUML = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEntsoeURIToGeographicalLocationVersionEvent event) {
    LOGGER.info("Event sourcing AssignEntsoeURIToGeographicalLocationVersionEvent");
    this.entsoeURI = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEntsoeURIFromGeographicalLocationVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignEntsoeURIFromGeographicalLocationVersionEvent");
    this.entsoeURI = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignModelDescriptionURIToGeographicalLocationVersionEvent event) {
    LOGGER.info("Event sourcing AssignModelDescriptionURIToGeographicalLocationVersionEvent");
    this.modelDescriptionURI = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignModelDescriptionURIFromGeographicalLocationVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignModelDescriptionURIFromGeographicalLocationVersionEvent");
    this.modelDescriptionURI = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignNamespaceRDFToGeographicalLocationVersionEvent event) {
    LOGGER.info("Event sourcing AssignNamespaceRDFToGeographicalLocationVersionEvent");
    this.namespaceRDF = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNamespaceRDFFromGeographicalLocationVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignNamespaceRDFFromGeographicalLocationVersionEvent");
    this.namespaceRDF = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignNamespaceUMLToGeographicalLocationVersionEvent event) {
    LOGGER.info("Event sourcing AssignNamespaceUMLToGeographicalLocationVersionEvent");
    this.namespaceUML = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNamespaceUMLFromGeographicalLocationVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignNamespaceUMLFromGeographicalLocationVersionEvent");
    this.namespaceUML = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignShortNameToGeographicalLocationVersionEvent event) {
    LOGGER.info("Event sourcing AssignShortNameToGeographicalLocationVersionEvent");
    this.shortName = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignShortNameFromGeographicalLocationVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignShortNameFromGeographicalLocationVersionEvent");
    this.shortName = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID geographicalLocationVersionId;

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
      Logger.getLogger(GeographicalLocationVersionAggregate.class.getName());
}
