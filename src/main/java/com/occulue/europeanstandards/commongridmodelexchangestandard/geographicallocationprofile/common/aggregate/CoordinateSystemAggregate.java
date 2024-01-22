package com.occulue.europeanstandards.commongridmodelexchangestandard.geographicallocationprofile.common.aggregate;

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
 * Aggregate handler for CoordinateSystem as outlined for the CQRS pattern, all write
 * responsibilities related to CoordinateSystem are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class CoordinateSystemAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public CoordinateSystemAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public CoordinateSystemAggregate(CreateCoordinateSystemCommand command) throws Exception {
    LOGGER.info("Handling command CreateCoordinateSystemCommand");
    CreateCoordinateSystemEvent event =
        new CreateCoordinateSystemEvent(command.getCoordinateSystemId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateCoordinateSystemCommand command) throws Exception {
    LOGGER.info("handling command UpdateCoordinateSystemCommand");
    UpdateCoordinateSystemEvent event =
        new UpdateCoordinateSystemEvent(command.getCoordinateSystemId(), command.getCrsUrn());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteCoordinateSystemCommand command) throws Exception {
    LOGGER.info("Handling command DeleteCoordinateSystemCommand");
    apply(new DeleteCoordinateSystemEvent(command.getCoordinateSystemId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignCrsUrnToCoordinateSystemCommand command) throws Exception {
    LOGGER.info("Handling command AssignCrsUrnToCoordinateSystemCommand");

    if (crsUrn != null && crsUrn.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "CrsUrn already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignCrsUrnToCoordinateSystemEvent(
            command.getCoordinateSystemId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignCrsUrnFromCoordinateSystemCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignCrsUrnFromCoordinateSystemCommand");

    if (crsUrn == null) throw new ProcessingException("CrsUrn already has nothing assigned.");

    apply(new UnAssignCrsUrnFromCoordinateSystemEvent(command.getCoordinateSystemId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateCoordinateSystemEvent event) {
    LOGGER.info("Event sourcing CreateCoordinateSystemEvent");
    this.coordinateSystemId = event.getCoordinateSystemId();
  }

  @EventSourcingHandler
  void on(UpdateCoordinateSystemEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.crsUrn = event.getCrsUrn();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignCrsUrnToCoordinateSystemEvent event) {
    LOGGER.info("Event sourcing AssignCrsUrnToCoordinateSystemEvent");
    this.crsUrn = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignCrsUrnFromCoordinateSystemEvent event) {
    LOGGER.info("Event sourcing UnAssignCrsUrnFromCoordinateSystemEvent");
    this.crsUrn = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID coordinateSystemId;

  private StringProxy crsUrn = null;

  private static final Logger LOGGER = Logger.getLogger(CoordinateSystemAggregate.class.getName());
}
