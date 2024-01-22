package com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile.aggregate;

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
 * Aggregate handler for DiagramLayoutVersion as outlined for the CQRS pattern, all write
 * responsibilities related to DiagramLayoutVersion are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class DiagramLayoutVersionAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public DiagramLayoutVersionAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public DiagramLayoutVersionAggregate(CreateDiagramLayoutVersionCommand command) throws Exception {
    LOGGER.info("Handling command CreateDiagramLayoutVersionCommand");
    CreateDiagramLayoutVersionEvent event =
        new CreateDiagramLayoutVersionEvent(command.getDiagramLayoutVersionId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateDiagramLayoutVersionCommand command) throws Exception {
    LOGGER.info("handling command UpdateDiagramLayoutVersionCommand");
    UpdateDiagramLayoutVersionEvent event =
        new UpdateDiagramLayoutVersionEvent(
            command.getDiagramLayoutVersionId(),
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
  public void handle(DeleteDiagramLayoutVersionCommand command) throws Exception {
    LOGGER.info("Handling command DeleteDiagramLayoutVersionCommand");
    apply(new DeleteDiagramLayoutVersionEvent(command.getDiagramLayoutVersionId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignBaseUMLToDiagramLayoutVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignBaseUMLToDiagramLayoutVersionCommand");

    if (baseUML != null && baseUML.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "BaseUML already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignBaseUMLToDiagramLayoutVersionEvent(
            command.getDiagramLayoutVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBaseUMLFromDiagramLayoutVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignBaseUMLFromDiagramLayoutVersionCommand");

    if (baseUML == null) throw new ProcessingException("BaseUML already has nothing assigned.");

    apply(new UnAssignBaseUMLFromDiagramLayoutVersionEvent(command.getDiagramLayoutVersionId()));
  }

  @CommandHandler
  public void handle(AssignBaseURIToDiagramLayoutVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignBaseURIToDiagramLayoutVersionCommand");

    if (baseURI != null && baseURI.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "BaseURI already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignBaseURIToDiagramLayoutVersionEvent(
            command.getDiagramLayoutVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBaseURIFromDiagramLayoutVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignBaseURIFromDiagramLayoutVersionCommand");

    if (baseURI == null) throw new ProcessingException("BaseURI already has nothing assigned.");

    apply(new UnAssignBaseURIFromDiagramLayoutVersionEvent(command.getDiagramLayoutVersionId()));
  }

  @CommandHandler
  public void handle(AssignDateToDiagramLayoutVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignDateToDiagramLayoutVersionCommand");

    if (date != null && date.getDateProxyId() == command.getAssignment().getDateProxyId())
      throw new ProcessingException(
          "Date already assigned with id " + command.getAssignment().getDateProxyId());

    apply(
        new AssignDateToDiagramLayoutVersionEvent(
            command.getDiagramLayoutVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDateFromDiagramLayoutVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDateFromDiagramLayoutVersionCommand");

    if (date == null) throw new ProcessingException("Date already has nothing assigned.");

    apply(new UnAssignDateFromDiagramLayoutVersionEvent(command.getDiagramLayoutVersionId()));
  }

  @CommandHandler
  public void handle(AssignDifferenceModelURIToDiagramLayoutVersionCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignDifferenceModelURIToDiagramLayoutVersionCommand");

    if (differenceModelURI != null
        && differenceModelURI.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "DifferenceModelURI already assigned with id "
              + command.getAssignment().getStringProxyId());

    apply(
        new AssignDifferenceModelURIToDiagramLayoutVersionEvent(
            command.getDiagramLayoutVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDifferenceModelURIFromDiagramLayoutVersionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignDifferenceModelURIFromDiagramLayoutVersionCommand");

    if (differenceModelURI == null)
      throw new ProcessingException("DifferenceModelURI already has nothing assigned.");

    apply(
        new UnAssignDifferenceModelURIFromDiagramLayoutVersionEvent(
            command.getDiagramLayoutVersionId()));
  }

  @CommandHandler
  public void handle(AssignEntsoeUMLToDiagramLayoutVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignEntsoeUMLToDiagramLayoutVersionCommand");

    if (entsoeUML != null
        && entsoeUML.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "EntsoeUML already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignEntsoeUMLToDiagramLayoutVersionEvent(
            command.getDiagramLayoutVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEntsoeUMLFromDiagramLayoutVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEntsoeUMLFromDiagramLayoutVersionCommand");

    if (entsoeUML == null) throw new ProcessingException("EntsoeUML already has nothing assigned.");

    apply(new UnAssignEntsoeUMLFromDiagramLayoutVersionEvent(command.getDiagramLayoutVersionId()));
  }

  @CommandHandler
  public void handle(AssignEntsoeURIToDiagramLayoutVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignEntsoeURIToDiagramLayoutVersionCommand");

    if (entsoeURI != null
        && entsoeURI.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "EntsoeURI already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignEntsoeURIToDiagramLayoutVersionEvent(
            command.getDiagramLayoutVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEntsoeURIFromDiagramLayoutVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEntsoeURIFromDiagramLayoutVersionCommand");

    if (entsoeURI == null) throw new ProcessingException("EntsoeURI already has nothing assigned.");

    apply(new UnAssignEntsoeURIFromDiagramLayoutVersionEvent(command.getDiagramLayoutVersionId()));
  }

  @CommandHandler
  public void handle(AssignModelDescriptionURIToDiagramLayoutVersionCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignModelDescriptionURIToDiagramLayoutVersionCommand");

    if (modelDescriptionURI != null
        && modelDescriptionURI.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "ModelDescriptionURI already assigned with id "
              + command.getAssignment().getStringProxyId());

    apply(
        new AssignModelDescriptionURIToDiagramLayoutVersionEvent(
            command.getDiagramLayoutVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignModelDescriptionURIFromDiagramLayoutVersionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignModelDescriptionURIFromDiagramLayoutVersionCommand");

    if (modelDescriptionURI == null)
      throw new ProcessingException("ModelDescriptionURI already has nothing assigned.");

    apply(
        new UnAssignModelDescriptionURIFromDiagramLayoutVersionEvent(
            command.getDiagramLayoutVersionId()));
  }

  @CommandHandler
  public void handle(AssignNamespaceRDFToDiagramLayoutVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignNamespaceRDFToDiagramLayoutVersionCommand");

    if (namespaceRDF != null
        && namespaceRDF.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "NamespaceRDF already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignNamespaceRDFToDiagramLayoutVersionEvent(
            command.getDiagramLayoutVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNamespaceRDFFromDiagramLayoutVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignNamespaceRDFFromDiagramLayoutVersionCommand");

    if (namespaceRDF == null)
      throw new ProcessingException("NamespaceRDF already has nothing assigned.");

    apply(
        new UnAssignNamespaceRDFFromDiagramLayoutVersionEvent(command.getDiagramLayoutVersionId()));
  }

  @CommandHandler
  public void handle(AssignNamespaceUMLToDiagramLayoutVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignNamespaceUMLToDiagramLayoutVersionCommand");

    if (namespaceUML != null
        && namespaceUML.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "NamespaceUML already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignNamespaceUMLToDiagramLayoutVersionEvent(
            command.getDiagramLayoutVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNamespaceUMLFromDiagramLayoutVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignNamespaceUMLFromDiagramLayoutVersionCommand");

    if (namespaceUML == null)
      throw new ProcessingException("NamespaceUML already has nothing assigned.");

    apply(
        new UnAssignNamespaceUMLFromDiagramLayoutVersionEvent(command.getDiagramLayoutVersionId()));
  }

  @CommandHandler
  public void handle(AssignShortNameToDiagramLayoutVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignShortNameToDiagramLayoutVersionCommand");

    if (shortName != null
        && shortName.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "ShortName already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignShortNameToDiagramLayoutVersionEvent(
            command.getDiagramLayoutVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignShortNameFromDiagramLayoutVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignShortNameFromDiagramLayoutVersionCommand");

    if (shortName == null) throw new ProcessingException("ShortName already has nothing assigned.");

    apply(new UnAssignShortNameFromDiagramLayoutVersionEvent(command.getDiagramLayoutVersionId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateDiagramLayoutVersionEvent event) {
    LOGGER.info("Event sourcing CreateDiagramLayoutVersionEvent");
    this.diagramLayoutVersionId = event.getDiagramLayoutVersionId();
  }

  @EventSourcingHandler
  void on(UpdateDiagramLayoutVersionEvent event) {
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
  void on(AssignBaseUMLToDiagramLayoutVersionEvent event) {
    LOGGER.info("Event sourcing AssignBaseUMLToDiagramLayoutVersionEvent");
    this.baseUML = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBaseUMLFromDiagramLayoutVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignBaseUMLFromDiagramLayoutVersionEvent");
    this.baseUML = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignBaseURIToDiagramLayoutVersionEvent event) {
    LOGGER.info("Event sourcing AssignBaseURIToDiagramLayoutVersionEvent");
    this.baseURI = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBaseURIFromDiagramLayoutVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignBaseURIFromDiagramLayoutVersionEvent");
    this.baseURI = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDateToDiagramLayoutVersionEvent event) {
    LOGGER.info("Event sourcing AssignDateToDiagramLayoutVersionEvent");
    this.date = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDateFromDiagramLayoutVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignDateFromDiagramLayoutVersionEvent");
    this.date = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDifferenceModelURIToDiagramLayoutVersionEvent event) {
    LOGGER.info("Event sourcing AssignDifferenceModelURIToDiagramLayoutVersionEvent");
    this.differenceModelURI = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDifferenceModelURIFromDiagramLayoutVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignDifferenceModelURIFromDiagramLayoutVersionEvent");
    this.differenceModelURI = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEntsoeUMLToDiagramLayoutVersionEvent event) {
    LOGGER.info("Event sourcing AssignEntsoeUMLToDiagramLayoutVersionEvent");
    this.entsoeUML = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEntsoeUMLFromDiagramLayoutVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignEntsoeUMLFromDiagramLayoutVersionEvent");
    this.entsoeUML = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEntsoeURIToDiagramLayoutVersionEvent event) {
    LOGGER.info("Event sourcing AssignEntsoeURIToDiagramLayoutVersionEvent");
    this.entsoeURI = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEntsoeURIFromDiagramLayoutVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignEntsoeURIFromDiagramLayoutVersionEvent");
    this.entsoeURI = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignModelDescriptionURIToDiagramLayoutVersionEvent event) {
    LOGGER.info("Event sourcing AssignModelDescriptionURIToDiagramLayoutVersionEvent");
    this.modelDescriptionURI = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignModelDescriptionURIFromDiagramLayoutVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignModelDescriptionURIFromDiagramLayoutVersionEvent");
    this.modelDescriptionURI = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignNamespaceRDFToDiagramLayoutVersionEvent event) {
    LOGGER.info("Event sourcing AssignNamespaceRDFToDiagramLayoutVersionEvent");
    this.namespaceRDF = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNamespaceRDFFromDiagramLayoutVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignNamespaceRDFFromDiagramLayoutVersionEvent");
    this.namespaceRDF = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignNamespaceUMLToDiagramLayoutVersionEvent event) {
    LOGGER.info("Event sourcing AssignNamespaceUMLToDiagramLayoutVersionEvent");
    this.namespaceUML = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNamespaceUMLFromDiagramLayoutVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignNamespaceUMLFromDiagramLayoutVersionEvent");
    this.namespaceUML = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignShortNameToDiagramLayoutVersionEvent event) {
    LOGGER.info("Event sourcing AssignShortNameToDiagramLayoutVersionEvent");
    this.shortName = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignShortNameFromDiagramLayoutVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignShortNameFromDiagramLayoutVersionEvent");
    this.shortName = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID diagramLayoutVersionId;

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
      Logger.getLogger(DiagramLayoutVersionAggregate.class.getName());
}
