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
 * Aggregate handler for VsConverter as outlined for the CQRS pattern, all write responsibilities
 * related to VsConverter are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class VsConverterAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public VsConverterAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public VsConverterAggregate(CreateVsConverterCommand command) throws Exception {
    LOGGER.info("Handling command CreateVsConverterCommand");
    CreateVsConverterEvent event = new CreateVsConverterEvent(command.getVsConverterId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateVsConverterCommand command) throws Exception {
    LOGGER.info("handling command UpdateVsConverterCommand");
    UpdateVsConverterEvent event =
        new UpdateVsConverterEvent(
            command.getVsConverterId(),
            command.getMaxModulationIndex(),
            command.getMaxValveCurrent(),
            command.getVsConverterDCSides());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteVsConverterCommand command) throws Exception {
    LOGGER.info("Handling command DeleteVsConverterCommand");
    apply(new DeleteVsConverterEvent(command.getVsConverterId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignMaxModulationIndexToVsConverterCommand command) throws Exception {
    LOGGER.info("Handling command AssignMaxModulationIndexToVsConverterCommand");

    if (maxModulationIndex != null
        && maxModulationIndex.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "MaxModulationIndex already assigned with id "
              + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignMaxModulationIndexToVsConverterEvent(
            command.getVsConverterId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMaxModulationIndexFromVsConverterCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMaxModulationIndexFromVsConverterCommand");

    if (maxModulationIndex == null)
      throw new ProcessingException("MaxModulationIndex already has nothing assigned.");

    apply(new UnAssignMaxModulationIndexFromVsConverterEvent(command.getVsConverterId()));
  }

  @CommandHandler
  public void handle(AssignMaxValveCurrentToVsConverterCommand command) throws Exception {
    LOGGER.info("Handling command AssignMaxValveCurrentToVsConverterCommand");

    if (maxValveCurrent != null
        && maxValveCurrent.getCurrentFlowId() == command.getAssignment().getCurrentFlowId())
      throw new ProcessingException(
          "MaxValveCurrent already assigned with id " + command.getAssignment().getCurrentFlowId());

    apply(
        new AssignMaxValveCurrentToVsConverterEvent(
            command.getVsConverterId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMaxValveCurrentFromVsConverterCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMaxValveCurrentFromVsConverterCommand");

    if (maxValveCurrent == null)
      throw new ProcessingException("MaxValveCurrent already has nothing assigned.");

    apply(new UnAssignMaxValveCurrentFromVsConverterEvent(command.getVsConverterId()));
  }

  // multiple association commands
  @CommandHandler
  public void handle(AssignVsConverterDCSidesToVsConverterCommand command) throws Exception {
    LOGGER.info("Handling command AssignVsConverterDCSidesToVsConverterCommand");

    if (vsConverterDCSides.contains(command.getAddTo()))
      throw new ProcessingException(
          "VsConverterDCSides already contains an entity with id "
              + command.getAddTo().getVsConverterId());

    apply(
        new AssignVsConverterDCSidesToVsConverterEvent(
            command.getVsConverterId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveVsConverterDCSidesFromVsConverterCommand command) throws Exception {
    LOGGER.info("Handling command RemoveVsConverterDCSidesFromVsConverterCommand");

    if (!vsConverterDCSides.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "VsConverterDCSides does not contain an entity with id "
              + command.getRemoveFrom().getVsConverterId());

    apply(
        new RemoveVsConverterDCSidesFromVsConverterEvent(
            command.getVsConverterId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateVsConverterEvent event) {
    LOGGER.info("Event sourcing CreateVsConverterEvent");
    this.vsConverterId = event.getVsConverterId();
  }

  @EventSourcingHandler
  void on(UpdateVsConverterEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.maxModulationIndex = event.getMaxModulationIndex();
    this.maxValveCurrent = event.getMaxValveCurrent();
    this.vsConverterDCSides = event.getVsConverterDCSides();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignMaxModulationIndexToVsConverterEvent event) {
    LOGGER.info("Event sourcing AssignMaxModulationIndexToVsConverterEvent");
    this.maxModulationIndex = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMaxModulationIndexFromVsConverterEvent event) {
    LOGGER.info("Event sourcing UnAssignMaxModulationIndexFromVsConverterEvent");
    this.maxModulationIndex = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMaxValveCurrentToVsConverterEvent event) {
    LOGGER.info("Event sourcing AssignMaxValveCurrentToVsConverterEvent");
    this.maxValveCurrent = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMaxValveCurrentFromVsConverterEvent event) {
    LOGGER.info("Event sourcing UnAssignMaxValveCurrentFromVsConverterEvent");
    this.maxValveCurrent = null;
  }

  // multiple associations
  @EventSourcingHandler
  void on(AssignVsConverterDCSidesToVsConverterEvent event) {
    LOGGER.info("Event sourcing AssignVsConverterDCSidesToVsConverterEvent");
    this.vsConverterDCSides.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveVsConverterDCSidesFromVsConverterEvent event) {
    LOGGER.info("Event sourcing RemoveVsConverterDCSidesFromVsConverterEvent");
    this.vsConverterDCSides.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID vsConverterId;

  private Simple_Float maxModulationIndex = null;
  private CurrentFlow maxValveCurrent = null;
  private Set<VsConverter> vsConverterDCSides = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(VsConverterAggregate.class.getName());
}
