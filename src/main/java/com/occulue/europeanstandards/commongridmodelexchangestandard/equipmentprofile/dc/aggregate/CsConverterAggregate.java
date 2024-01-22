package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.aggregate;

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
 * Aggregate handler for CsConverter as outlined for the CQRS pattern, all write responsibilities
 * related to CsConverter are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class CsConverterAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public CsConverterAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public CsConverterAggregate(CreateCsConverterCommand command) throws Exception {
    LOGGER.info("Handling command CreateCsConverterCommand");
    CreateCsConverterEvent event = new CreateCsConverterEvent(command.getCsConverterId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateCsConverterCommand command) throws Exception {
    LOGGER.info("handling command UpdateCsConverterCommand");
    UpdateCsConverterEvent event =
        new UpdateCsConverterEvent(
            command.getCsConverterId(),
            command.getMaxAlpha(),
            command.getMaxGamma(),
            command.getMaxIdc(),
            command.getMinAlpha(),
            command.getMinGamma(),
            command.getMinIdc(),
            command.getRatedIdc());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteCsConverterCommand command) throws Exception {
    LOGGER.info("Handling command DeleteCsConverterCommand");
    apply(new DeleteCsConverterEvent(command.getCsConverterId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignMaxAlphaToCsConverterCommand command) throws Exception {
    LOGGER.info("Handling command AssignMaxAlphaToCsConverterCommand");

    if (maxAlpha != null
        && maxAlpha.getAngleDegreesId() == command.getAssignment().getAngleDegreesId())
      throw new ProcessingException(
          "MaxAlpha already assigned with id " + command.getAssignment().getAngleDegreesId());

    apply(
        new AssignMaxAlphaToCsConverterEvent(command.getCsConverterId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMaxAlphaFromCsConverterCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMaxAlphaFromCsConverterCommand");

    if (maxAlpha == null) throw new ProcessingException("MaxAlpha already has nothing assigned.");

    apply(new UnAssignMaxAlphaFromCsConverterEvent(command.getCsConverterId()));
  }

  @CommandHandler
  public void handle(AssignMaxGammaToCsConverterCommand command) throws Exception {
    LOGGER.info("Handling command AssignMaxGammaToCsConverterCommand");

    if (maxGamma != null
        && maxGamma.getAngleDegreesId() == command.getAssignment().getAngleDegreesId())
      throw new ProcessingException(
          "MaxGamma already assigned with id " + command.getAssignment().getAngleDegreesId());

    apply(
        new AssignMaxGammaToCsConverterEvent(command.getCsConverterId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMaxGammaFromCsConverterCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMaxGammaFromCsConverterCommand");

    if (maxGamma == null) throw new ProcessingException("MaxGamma already has nothing assigned.");

    apply(new UnAssignMaxGammaFromCsConverterEvent(command.getCsConverterId()));
  }

  @CommandHandler
  public void handle(AssignMaxIdcToCsConverterCommand command) throws Exception {
    LOGGER.info("Handling command AssignMaxIdcToCsConverterCommand");

    if (maxIdc != null && maxIdc.getCurrentFlowId() == command.getAssignment().getCurrentFlowId())
      throw new ProcessingException(
          "MaxIdc already assigned with id " + command.getAssignment().getCurrentFlowId());

    apply(new AssignMaxIdcToCsConverterEvent(command.getCsConverterId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMaxIdcFromCsConverterCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMaxIdcFromCsConverterCommand");

    if (maxIdc == null) throw new ProcessingException("MaxIdc already has nothing assigned.");

    apply(new UnAssignMaxIdcFromCsConverterEvent(command.getCsConverterId()));
  }

  @CommandHandler
  public void handle(AssignMinAlphaToCsConverterCommand command) throws Exception {
    LOGGER.info("Handling command AssignMinAlphaToCsConverterCommand");

    if (minAlpha != null
        && minAlpha.getAngleDegreesId() == command.getAssignment().getAngleDegreesId())
      throw new ProcessingException(
          "MinAlpha already assigned with id " + command.getAssignment().getAngleDegreesId());

    apply(
        new AssignMinAlphaToCsConverterEvent(command.getCsConverterId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMinAlphaFromCsConverterCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMinAlphaFromCsConverterCommand");

    if (minAlpha == null) throw new ProcessingException("MinAlpha already has nothing assigned.");

    apply(new UnAssignMinAlphaFromCsConverterEvent(command.getCsConverterId()));
  }

  @CommandHandler
  public void handle(AssignMinGammaToCsConverterCommand command) throws Exception {
    LOGGER.info("Handling command AssignMinGammaToCsConverterCommand");

    if (minGamma != null
        && minGamma.getAngleDegreesId() == command.getAssignment().getAngleDegreesId())
      throw new ProcessingException(
          "MinGamma already assigned with id " + command.getAssignment().getAngleDegreesId());

    apply(
        new AssignMinGammaToCsConverterEvent(command.getCsConverterId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMinGammaFromCsConverterCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMinGammaFromCsConverterCommand");

    if (minGamma == null) throw new ProcessingException("MinGamma already has nothing assigned.");

    apply(new UnAssignMinGammaFromCsConverterEvent(command.getCsConverterId()));
  }

  @CommandHandler
  public void handle(AssignMinIdcToCsConverterCommand command) throws Exception {
    LOGGER.info("Handling command AssignMinIdcToCsConverterCommand");

    if (minIdc != null && minIdc.getCurrentFlowId() == command.getAssignment().getCurrentFlowId())
      throw new ProcessingException(
          "MinIdc already assigned with id " + command.getAssignment().getCurrentFlowId());

    apply(new AssignMinIdcToCsConverterEvent(command.getCsConverterId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMinIdcFromCsConverterCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMinIdcFromCsConverterCommand");

    if (minIdc == null) throw new ProcessingException("MinIdc already has nothing assigned.");

    apply(new UnAssignMinIdcFromCsConverterEvent(command.getCsConverterId()));
  }

  @CommandHandler
  public void handle(AssignRatedIdcToCsConverterCommand command) throws Exception {
    LOGGER.info("Handling command AssignRatedIdcToCsConverterCommand");

    if (ratedIdc != null
        && ratedIdc.getCurrentFlowId() == command.getAssignment().getCurrentFlowId())
      throw new ProcessingException(
          "RatedIdc already assigned with id " + command.getAssignment().getCurrentFlowId());

    apply(
        new AssignRatedIdcToCsConverterEvent(command.getCsConverterId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRatedIdcFromCsConverterCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignRatedIdcFromCsConverterCommand");

    if (ratedIdc == null) throw new ProcessingException("RatedIdc already has nothing assigned.");

    apply(new UnAssignRatedIdcFromCsConverterEvent(command.getCsConverterId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateCsConverterEvent event) {
    LOGGER.info("Event sourcing CreateCsConverterEvent");
    this.csConverterId = event.getCsConverterId();
  }

  @EventSourcingHandler
  void on(UpdateCsConverterEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.maxAlpha = event.getMaxAlpha();
    this.maxGamma = event.getMaxGamma();
    this.maxIdc = event.getMaxIdc();
    this.minAlpha = event.getMinAlpha();
    this.minGamma = event.getMinGamma();
    this.minIdc = event.getMinIdc();
    this.ratedIdc = event.getRatedIdc();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignMaxAlphaToCsConverterEvent event) {
    LOGGER.info("Event sourcing AssignMaxAlphaToCsConverterEvent");
    this.maxAlpha = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMaxAlphaFromCsConverterEvent event) {
    LOGGER.info("Event sourcing UnAssignMaxAlphaFromCsConverterEvent");
    this.maxAlpha = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMaxGammaToCsConverterEvent event) {
    LOGGER.info("Event sourcing AssignMaxGammaToCsConverterEvent");
    this.maxGamma = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMaxGammaFromCsConverterEvent event) {
    LOGGER.info("Event sourcing UnAssignMaxGammaFromCsConverterEvent");
    this.maxGamma = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMaxIdcToCsConverterEvent event) {
    LOGGER.info("Event sourcing AssignMaxIdcToCsConverterEvent");
    this.maxIdc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMaxIdcFromCsConverterEvent event) {
    LOGGER.info("Event sourcing UnAssignMaxIdcFromCsConverterEvent");
    this.maxIdc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMinAlphaToCsConverterEvent event) {
    LOGGER.info("Event sourcing AssignMinAlphaToCsConverterEvent");
    this.minAlpha = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMinAlphaFromCsConverterEvent event) {
    LOGGER.info("Event sourcing UnAssignMinAlphaFromCsConverterEvent");
    this.minAlpha = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMinGammaToCsConverterEvent event) {
    LOGGER.info("Event sourcing AssignMinGammaToCsConverterEvent");
    this.minGamma = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMinGammaFromCsConverterEvent event) {
    LOGGER.info("Event sourcing UnAssignMinGammaFromCsConverterEvent");
    this.minGamma = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMinIdcToCsConverterEvent event) {
    LOGGER.info("Event sourcing AssignMinIdcToCsConverterEvent");
    this.minIdc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMinIdcFromCsConverterEvent event) {
    LOGGER.info("Event sourcing UnAssignMinIdcFromCsConverterEvent");
    this.minIdc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRatedIdcToCsConverterEvent event) {
    LOGGER.info("Event sourcing AssignRatedIdcToCsConverterEvent");
    this.ratedIdc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRatedIdcFromCsConverterEvent event) {
    LOGGER.info("Event sourcing UnAssignRatedIdcFromCsConverterEvent");
    this.ratedIdc = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID csConverterId;

  private AngleDegrees maxAlpha = null;
  private AngleDegrees maxGamma = null;
  private CurrentFlow maxIdc = null;
  private AngleDegrees minAlpha = null;
  private AngleDegrees minGamma = null;
  private CurrentFlow minIdc = null;
  private CurrentFlow ratedIdc = null;

  private static final Logger LOGGER = Logger.getLogger(CsConverterAggregate.class.getName());
}
