package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.aggregate;

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
 * Aggregate handler for CurveData as outlined for the CQRS pattern, all write responsibilities
 * related to CurveData are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class CurveDataAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public CurveDataAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public CurveDataAggregate(CreateCurveDataCommand command) throws Exception {
    LOGGER.info("Handling command CreateCurveDataCommand");
    CreateCurveDataEvent event = new CreateCurveDataEvent(command.getCurveDataId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateCurveDataCommand command) throws Exception {
    LOGGER.info("handling command UpdateCurveDataCommand");
    UpdateCurveDataEvent event =
        new UpdateCurveDataEvent(
            command.getCurveDataId(),
            command.getXvalue(),
            command.getY1value(),
            command.getY2value(),
            command.getCurveDatas());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteCurveDataCommand command) throws Exception {
    LOGGER.info("Handling command DeleteCurveDataCommand");
    apply(new DeleteCurveDataEvent(command.getCurveDataId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignXvalueToCurveDataCommand command) throws Exception {
    LOGGER.info("Handling command AssignXvalueToCurveDataCommand");

    if (xvalue != null && xvalue.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Xvalue already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignXvalueToCurveDataEvent(command.getCurveDataId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXvalueFromCurveDataCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignXvalueFromCurveDataCommand");

    if (xvalue == null) throw new ProcessingException("Xvalue already has nothing assigned.");

    apply(new UnAssignXvalueFromCurveDataEvent(command.getCurveDataId()));
  }

  @CommandHandler
  public void handle(AssignY1valueToCurveDataCommand command) throws Exception {
    LOGGER.info("Handling command AssignY1valueToCurveDataCommand");

    if (y1value != null
        && y1value.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Y1value already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignY1valueToCurveDataEvent(command.getCurveDataId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignY1valueFromCurveDataCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignY1valueFromCurveDataCommand");

    if (y1value == null) throw new ProcessingException("Y1value already has nothing assigned.");

    apply(new UnAssignY1valueFromCurveDataEvent(command.getCurveDataId()));
  }

  @CommandHandler
  public void handle(AssignY2valueToCurveDataCommand command) throws Exception {
    LOGGER.info("Handling command AssignY2valueToCurveDataCommand");

    if (y2value != null
        && y2value.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Y2value already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignY2valueToCurveDataEvent(command.getCurveDataId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignY2valueFromCurveDataCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignY2valueFromCurveDataCommand");

    if (y2value == null) throw new ProcessingException("Y2value already has nothing assigned.");

    apply(new UnAssignY2valueFromCurveDataEvent(command.getCurveDataId()));
  }

  // multiple association commands
  @CommandHandler
  public void handle(AssignCurveDatasToCurveDataCommand command) throws Exception {
    LOGGER.info("Handling command AssignCurveDatasToCurveDataCommand");

    if (curveDatas.contains(command.getAddTo()))
      throw new ProcessingException(
          "CurveDatas already contains an entity with id " + command.getAddTo().getCurveDataId());

    apply(new AssignCurveDatasToCurveDataEvent(command.getCurveDataId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveCurveDatasFromCurveDataCommand command) throws Exception {
    LOGGER.info("Handling command RemoveCurveDatasFromCurveDataCommand");

    if (!curveDatas.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "CurveDatas does not contain an entity with id "
              + command.getRemoveFrom().getCurveDataId());

    apply(
        new RemoveCurveDatasFromCurveDataEvent(command.getCurveDataId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateCurveDataEvent event) {
    LOGGER.info("Event sourcing CreateCurveDataEvent");
    this.curveDataId = event.getCurveDataId();
  }

  @EventSourcingHandler
  void on(UpdateCurveDataEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.xvalue = event.getXvalue();
    this.y1value = event.getY1value();
    this.y2value = event.getY2value();
    this.curveDatas = event.getCurveDatas();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignXvalueToCurveDataEvent event) {
    LOGGER.info("Event sourcing AssignXvalueToCurveDataEvent");
    this.xvalue = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXvalueFromCurveDataEvent event) {
    LOGGER.info("Event sourcing UnAssignXvalueFromCurveDataEvent");
    this.xvalue = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignY1valueToCurveDataEvent event) {
    LOGGER.info("Event sourcing AssignY1valueToCurveDataEvent");
    this.y1value = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignY1valueFromCurveDataEvent event) {
    LOGGER.info("Event sourcing UnAssignY1valueFromCurveDataEvent");
    this.y1value = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignY2valueToCurveDataEvent event) {
    LOGGER.info("Event sourcing AssignY2valueToCurveDataEvent");
    this.y2value = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignY2valueFromCurveDataEvent event) {
    LOGGER.info("Event sourcing UnAssignY2valueFromCurveDataEvent");
    this.y2value = null;
  }

  // multiple associations
  @EventSourcingHandler
  void on(AssignCurveDatasToCurveDataEvent event) {
    LOGGER.info("Event sourcing AssignCurveDatasToCurveDataEvent");
    this.curveDatas.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveCurveDatasFromCurveDataEvent event) {
    LOGGER.info("Event sourcing RemoveCurveDatasFromCurveDataEvent");
    this.curveDatas.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID curveDataId;

  private Simple_Float xvalue = null;
  private Simple_Float y1value = null;
  private Simple_Float y2value = null;
  private Set<CurveData> curveDatas = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(CurveDataAggregate.class.getName());
}
