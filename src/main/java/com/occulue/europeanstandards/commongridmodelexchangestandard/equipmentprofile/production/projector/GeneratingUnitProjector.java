/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for GeneratingUnit as outlined for the CQRS pattern. All event handling and query
 * handling related to GeneratingUnit are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by GeneratingUnitAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("generatingUnit")
@Component("generatingUnit-projector")
public class GeneratingUnitProjector extends GeneratingUnitEntityProjector {

  // core constructor
  public GeneratingUnitProjector(
      GeneratingUnitRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateGeneratingUnitEvent
   */
  @EventHandler(payloadType = CreateGeneratingUnitEvent.class)
  public void handle(CreateGeneratingUnitEvent event) {
    LOGGER.info("handling CreateGeneratingUnitEvent - " + event);
    GeneratingUnit entity = new GeneratingUnit();
    entity.setGeneratingUnitId(event.getGeneratingUnitId());
    entity.setGenControlSource(event.getGenControlSource());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeneratingUnit(entity);
  }

  /*
   * @param	event UpdateGeneratingUnitEvent
   */
  @EventHandler(payloadType = UpdateGeneratingUnitEvent.class)
  public void handle(UpdateGeneratingUnitEvent event) {
    LOGGER.info("handling UpdateGeneratingUnitEvent - " + event);

    GeneratingUnit entity = new GeneratingUnit();
    entity.setGeneratingUnitId(event.getGeneratingUnitId());
    entity.setGenControlSource(event.getGenControlSource());
    entity.setGovernorSCD(event.getGovernorSCD());
    entity.setInitialP(event.getInitialP());
    entity.setLongPF(event.getLongPF());
    entity.setMaximumAllowableSpinningReserve(event.getMaximumAllowableSpinningReserve());
    entity.setMaxOperatingP(event.getMaxOperatingP());
    entity.setMinOperatingP(event.getMinOperatingP());
    entity.setNominalP(event.getNominalP());
    entity.setRatedGrossMaxP(event.getRatedGrossMaxP());
    entity.setRatedGrossMinP(event.getRatedGrossMinP());
    entity.setRatedNetMaxP(event.getRatedNetMaxP());
    entity.setShortPF(event.getShortPF());
    entity.setStartupCost(event.getStartupCost());
    entity.setTotalEfficiency(event.getTotalEfficiency());
    entity.setVariableCost(event.getVariableCost());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeneratingUnit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeneratingUnit(entity);
  }

  /*
   * @param	event DeleteGeneratingUnitEvent
   */
  @EventHandler(payloadType = DeleteGeneratingUnitEvent.class)
  public void handle(DeleteGeneratingUnitEvent event) {
    LOGGER.info("handling DeleteGeneratingUnitEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    GeneratingUnit entity = delete(event.getGeneratingUnitId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeneratingUnit(entity);
  }

  /*
   * @param	event AssignGovernorSCDToGeneratingUnitEvent
   */
  @EventHandler(payloadType = AssignGovernorSCDToGeneratingUnitEvent.class)
  public void handle(AssignGovernorSCDToGeneratingUnitEvent event) {
    LOGGER.info("handling AssignGovernorSCDToGeneratingUnitEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GeneratingUnit entity = assignGovernorSCD(event.getGeneratingUnitId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeneratingUnit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeneratingUnit(entity);
  }

  /*
   * @param	event UnAssignGovernorSCDFromGeneratingUnitEvent
   */
  @EventHandler(payloadType = UnAssignGovernorSCDFromGeneratingUnitEvent.class)
  public void handle(UnAssignGovernorSCDFromGeneratingUnitEvent event) {
    LOGGER.info("handling UnAssignGovernorSCDFromGeneratingUnitEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GeneratingUnit entity = unAssignGovernorSCD(event.getGeneratingUnitId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeneratingUnit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeneratingUnit(entity);
  }

  /*
   * @param	event AssignInitialPToGeneratingUnitEvent
   */
  @EventHandler(payloadType = AssignInitialPToGeneratingUnitEvent.class)
  public void handle(AssignInitialPToGeneratingUnitEvent event) {
    LOGGER.info("handling AssignInitialPToGeneratingUnitEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GeneratingUnit entity = assignInitialP(event.getGeneratingUnitId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeneratingUnit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeneratingUnit(entity);
  }

  /*
   * @param	event UnAssignInitialPFromGeneratingUnitEvent
   */
  @EventHandler(payloadType = UnAssignInitialPFromGeneratingUnitEvent.class)
  public void handle(UnAssignInitialPFromGeneratingUnitEvent event) {
    LOGGER.info("handling UnAssignInitialPFromGeneratingUnitEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GeneratingUnit entity = unAssignInitialP(event.getGeneratingUnitId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeneratingUnit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeneratingUnit(entity);
  }

  /*
   * @param	event AssignLongPFToGeneratingUnitEvent
   */
  @EventHandler(payloadType = AssignLongPFToGeneratingUnitEvent.class)
  public void handle(AssignLongPFToGeneratingUnitEvent event) {
    LOGGER.info("handling AssignLongPFToGeneratingUnitEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GeneratingUnit entity = assignLongPF(event.getGeneratingUnitId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeneratingUnit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeneratingUnit(entity);
  }

  /*
   * @param	event UnAssignLongPFFromGeneratingUnitEvent
   */
  @EventHandler(payloadType = UnAssignLongPFFromGeneratingUnitEvent.class)
  public void handle(UnAssignLongPFFromGeneratingUnitEvent event) {
    LOGGER.info("handling UnAssignLongPFFromGeneratingUnitEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GeneratingUnit entity = unAssignLongPF(event.getGeneratingUnitId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeneratingUnit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeneratingUnit(entity);
  }

  /*
   * @param	event AssignMaximumAllowableSpinningReserveToGeneratingUnitEvent
   */
  @EventHandler(payloadType = AssignMaximumAllowableSpinningReserveToGeneratingUnitEvent.class)
  public void handle(AssignMaximumAllowableSpinningReserveToGeneratingUnitEvent event) {
    LOGGER.info("handling AssignMaximumAllowableSpinningReserveToGeneratingUnitEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GeneratingUnit entity =
        assignMaximumAllowableSpinningReserve(event.getGeneratingUnitId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeneratingUnit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeneratingUnit(entity);
  }

  /*
   * @param	event UnAssignMaximumAllowableSpinningReserveFromGeneratingUnitEvent
   */
  @EventHandler(payloadType = UnAssignMaximumAllowableSpinningReserveFromGeneratingUnitEvent.class)
  public void handle(UnAssignMaximumAllowableSpinningReserveFromGeneratingUnitEvent event) {
    LOGGER.info(
        "handling UnAssignMaximumAllowableSpinningReserveFromGeneratingUnitEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GeneratingUnit entity = unAssignMaximumAllowableSpinningReserve(event.getGeneratingUnitId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeneratingUnit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeneratingUnit(entity);
  }

  /*
   * @param	event AssignMaxOperatingPToGeneratingUnitEvent
   */
  @EventHandler(payloadType = AssignMaxOperatingPToGeneratingUnitEvent.class)
  public void handle(AssignMaxOperatingPToGeneratingUnitEvent event) {
    LOGGER.info("handling AssignMaxOperatingPToGeneratingUnitEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GeneratingUnit entity = assignMaxOperatingP(event.getGeneratingUnitId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeneratingUnit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeneratingUnit(entity);
  }

  /*
   * @param	event UnAssignMaxOperatingPFromGeneratingUnitEvent
   */
  @EventHandler(payloadType = UnAssignMaxOperatingPFromGeneratingUnitEvent.class)
  public void handle(UnAssignMaxOperatingPFromGeneratingUnitEvent event) {
    LOGGER.info("handling UnAssignMaxOperatingPFromGeneratingUnitEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GeneratingUnit entity = unAssignMaxOperatingP(event.getGeneratingUnitId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeneratingUnit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeneratingUnit(entity);
  }

  /*
   * @param	event AssignMinOperatingPToGeneratingUnitEvent
   */
  @EventHandler(payloadType = AssignMinOperatingPToGeneratingUnitEvent.class)
  public void handle(AssignMinOperatingPToGeneratingUnitEvent event) {
    LOGGER.info("handling AssignMinOperatingPToGeneratingUnitEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GeneratingUnit entity = assignMinOperatingP(event.getGeneratingUnitId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeneratingUnit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeneratingUnit(entity);
  }

  /*
   * @param	event UnAssignMinOperatingPFromGeneratingUnitEvent
   */
  @EventHandler(payloadType = UnAssignMinOperatingPFromGeneratingUnitEvent.class)
  public void handle(UnAssignMinOperatingPFromGeneratingUnitEvent event) {
    LOGGER.info("handling UnAssignMinOperatingPFromGeneratingUnitEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GeneratingUnit entity = unAssignMinOperatingP(event.getGeneratingUnitId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeneratingUnit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeneratingUnit(entity);
  }

  /*
   * @param	event AssignNominalPToGeneratingUnitEvent
   */
  @EventHandler(payloadType = AssignNominalPToGeneratingUnitEvent.class)
  public void handle(AssignNominalPToGeneratingUnitEvent event) {
    LOGGER.info("handling AssignNominalPToGeneratingUnitEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GeneratingUnit entity = assignNominalP(event.getGeneratingUnitId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeneratingUnit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeneratingUnit(entity);
  }

  /*
   * @param	event UnAssignNominalPFromGeneratingUnitEvent
   */
  @EventHandler(payloadType = UnAssignNominalPFromGeneratingUnitEvent.class)
  public void handle(UnAssignNominalPFromGeneratingUnitEvent event) {
    LOGGER.info("handling UnAssignNominalPFromGeneratingUnitEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GeneratingUnit entity = unAssignNominalP(event.getGeneratingUnitId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeneratingUnit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeneratingUnit(entity);
  }

  /*
   * @param	event AssignRatedGrossMaxPToGeneratingUnitEvent
   */
  @EventHandler(payloadType = AssignRatedGrossMaxPToGeneratingUnitEvent.class)
  public void handle(AssignRatedGrossMaxPToGeneratingUnitEvent event) {
    LOGGER.info("handling AssignRatedGrossMaxPToGeneratingUnitEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GeneratingUnit entity =
        assignRatedGrossMaxP(event.getGeneratingUnitId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeneratingUnit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeneratingUnit(entity);
  }

  /*
   * @param	event UnAssignRatedGrossMaxPFromGeneratingUnitEvent
   */
  @EventHandler(payloadType = UnAssignRatedGrossMaxPFromGeneratingUnitEvent.class)
  public void handle(UnAssignRatedGrossMaxPFromGeneratingUnitEvent event) {
    LOGGER.info("handling UnAssignRatedGrossMaxPFromGeneratingUnitEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GeneratingUnit entity = unAssignRatedGrossMaxP(event.getGeneratingUnitId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeneratingUnit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeneratingUnit(entity);
  }

  /*
   * @param	event AssignRatedGrossMinPToGeneratingUnitEvent
   */
  @EventHandler(payloadType = AssignRatedGrossMinPToGeneratingUnitEvent.class)
  public void handle(AssignRatedGrossMinPToGeneratingUnitEvent event) {
    LOGGER.info("handling AssignRatedGrossMinPToGeneratingUnitEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GeneratingUnit entity =
        assignRatedGrossMinP(event.getGeneratingUnitId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeneratingUnit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeneratingUnit(entity);
  }

  /*
   * @param	event UnAssignRatedGrossMinPFromGeneratingUnitEvent
   */
  @EventHandler(payloadType = UnAssignRatedGrossMinPFromGeneratingUnitEvent.class)
  public void handle(UnAssignRatedGrossMinPFromGeneratingUnitEvent event) {
    LOGGER.info("handling UnAssignRatedGrossMinPFromGeneratingUnitEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GeneratingUnit entity = unAssignRatedGrossMinP(event.getGeneratingUnitId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeneratingUnit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeneratingUnit(entity);
  }

  /*
   * @param	event AssignRatedNetMaxPToGeneratingUnitEvent
   */
  @EventHandler(payloadType = AssignRatedNetMaxPToGeneratingUnitEvent.class)
  public void handle(AssignRatedNetMaxPToGeneratingUnitEvent event) {
    LOGGER.info("handling AssignRatedNetMaxPToGeneratingUnitEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GeneratingUnit entity = assignRatedNetMaxP(event.getGeneratingUnitId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeneratingUnit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeneratingUnit(entity);
  }

  /*
   * @param	event UnAssignRatedNetMaxPFromGeneratingUnitEvent
   */
  @EventHandler(payloadType = UnAssignRatedNetMaxPFromGeneratingUnitEvent.class)
  public void handle(UnAssignRatedNetMaxPFromGeneratingUnitEvent event) {
    LOGGER.info("handling UnAssignRatedNetMaxPFromGeneratingUnitEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GeneratingUnit entity = unAssignRatedNetMaxP(event.getGeneratingUnitId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeneratingUnit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeneratingUnit(entity);
  }

  /*
   * @param	event AssignShortPFToGeneratingUnitEvent
   */
  @EventHandler(payloadType = AssignShortPFToGeneratingUnitEvent.class)
  public void handle(AssignShortPFToGeneratingUnitEvent event) {
    LOGGER.info("handling AssignShortPFToGeneratingUnitEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GeneratingUnit entity = assignShortPF(event.getGeneratingUnitId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeneratingUnit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeneratingUnit(entity);
  }

  /*
   * @param	event UnAssignShortPFFromGeneratingUnitEvent
   */
  @EventHandler(payloadType = UnAssignShortPFFromGeneratingUnitEvent.class)
  public void handle(UnAssignShortPFFromGeneratingUnitEvent event) {
    LOGGER.info("handling UnAssignShortPFFromGeneratingUnitEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GeneratingUnit entity = unAssignShortPF(event.getGeneratingUnitId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeneratingUnit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeneratingUnit(entity);
  }

  /*
   * @param	event AssignStartupCostToGeneratingUnitEvent
   */
  @EventHandler(payloadType = AssignStartupCostToGeneratingUnitEvent.class)
  public void handle(AssignStartupCostToGeneratingUnitEvent event) {
    LOGGER.info("handling AssignStartupCostToGeneratingUnitEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GeneratingUnit entity = assignStartupCost(event.getGeneratingUnitId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeneratingUnit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeneratingUnit(entity);
  }

  /*
   * @param	event UnAssignStartupCostFromGeneratingUnitEvent
   */
  @EventHandler(payloadType = UnAssignStartupCostFromGeneratingUnitEvent.class)
  public void handle(UnAssignStartupCostFromGeneratingUnitEvent event) {
    LOGGER.info("handling UnAssignStartupCostFromGeneratingUnitEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GeneratingUnit entity = unAssignStartupCost(event.getGeneratingUnitId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeneratingUnit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeneratingUnit(entity);
  }

  /*
   * @param	event AssignTotalEfficiencyToGeneratingUnitEvent
   */
  @EventHandler(payloadType = AssignTotalEfficiencyToGeneratingUnitEvent.class)
  public void handle(AssignTotalEfficiencyToGeneratingUnitEvent event) {
    LOGGER.info("handling AssignTotalEfficiencyToGeneratingUnitEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GeneratingUnit entity =
        assignTotalEfficiency(event.getGeneratingUnitId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeneratingUnit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeneratingUnit(entity);
  }

  /*
   * @param	event UnAssignTotalEfficiencyFromGeneratingUnitEvent
   */
  @EventHandler(payloadType = UnAssignTotalEfficiencyFromGeneratingUnitEvent.class)
  public void handle(UnAssignTotalEfficiencyFromGeneratingUnitEvent event) {
    LOGGER.info("handling UnAssignTotalEfficiencyFromGeneratingUnitEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GeneratingUnit entity = unAssignTotalEfficiency(event.getGeneratingUnitId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeneratingUnit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeneratingUnit(entity);
  }

  /*
   * @param	event AssignVariableCostToGeneratingUnitEvent
   */
  @EventHandler(payloadType = AssignVariableCostToGeneratingUnitEvent.class)
  public void handle(AssignVariableCostToGeneratingUnitEvent event) {
    LOGGER.info("handling AssignVariableCostToGeneratingUnitEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GeneratingUnit entity = assignVariableCost(event.getGeneratingUnitId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeneratingUnit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeneratingUnit(entity);
  }

  /*
   * @param	event UnAssignVariableCostFromGeneratingUnitEvent
   */
  @EventHandler(payloadType = UnAssignVariableCostFromGeneratingUnitEvent.class)
  public void handle(UnAssignVariableCostFromGeneratingUnitEvent event) {
    LOGGER.info("handling UnAssignVariableCostFromGeneratingUnitEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GeneratingUnit entity = unAssignVariableCost(event.getGeneratingUnitId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeneratingUnit(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeneratingUnit(entity);
  }

  /**
   * Method to retrieve the GeneratingUnit via an GeneratingUnitPrimaryKey.
   *
   * @param id Long
   * @return GeneratingUnit
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public GeneratingUnit handle(FindGeneratingUnitQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getGeneratingUnitId());
  }

  /**
   * Method to retrieve a collection of all GeneratingUnits
   *
   * @param query FindAllGeneratingUnitQuery
   * @return List<GeneratingUnit>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<GeneratingUnit> handle(FindAllGeneratingUnitQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindGeneratingUnit, but only if the id matches
   *
   * @param entity GeneratingUnit
   */
  protected void emitFindGeneratingUnit(GeneratingUnit entity) {
    LOGGER.info("handling emitFindGeneratingUnit");

    queryUpdateEmitter.emit(
        FindGeneratingUnitQuery.class,
        query -> query.getFilter().getGeneratingUnitId().equals(entity.getGeneratingUnitId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllGeneratingUnit
   *
   * @param entity GeneratingUnit
   */
  protected void emitFindAllGeneratingUnit(GeneratingUnit entity) {
    LOGGER.info("handling emitFindAllGeneratingUnit");

    queryUpdateEmitter.emit(FindAllGeneratingUnitQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(GeneratingUnitProjector.class.getName());
}
