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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.synchronousmachinedynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.synchronousmachinedynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for SynchronousMachineDetailed as outlined for the CQRS pattern. All event handling and
 * query handling related to SynchronousMachineDetailed are invoked here and dispersed as an event
 * to be handled elsewhere.
 *
 * <p>Commands are handled by SynchronousMachineDetailedAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("synchronousMachineDetailed")
@Component("synchronousMachineDetailed-projector")
public class SynchronousMachineDetailedProjector extends SynchronousMachineDetailedEntityProjector {

  // core constructor
  public SynchronousMachineDetailedProjector(
      SynchronousMachineDetailedRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateSynchronousMachineDetailedEvent
   */
  @EventHandler(payloadType = CreateSynchronousMachineDetailedEvent.class)
  public void handle(CreateSynchronousMachineDetailedEvent event) {
    LOGGER.info("handling CreateSynchronousMachineDetailedEvent - " + event);
    SynchronousMachineDetailed entity = new SynchronousMachineDetailed();
    entity.setSynchronousMachineDetailedId(event.getSynchronousMachineDetailedId());
    entity.setIfdBaseType(event.getIfdBaseType());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineDetailed(entity);
  }

  /*
   * @param	event UpdateSynchronousMachineDetailedEvent
   */
  @EventHandler(payloadType = UpdateSynchronousMachineDetailedEvent.class)
  public void handle(UpdateSynchronousMachineDetailedEvent event) {
    LOGGER.info("handling UpdateSynchronousMachineDetailedEvent - " + event);

    SynchronousMachineDetailed entity = new SynchronousMachineDetailed();
    entity.setSynchronousMachineDetailedId(event.getSynchronousMachineDetailedId());
    entity.setEfdBaseRatio(event.getEfdBaseRatio());
    entity.setIfdBaseType(event.getIfdBaseType());
    entity.setIfdBaseValue(event.getIfdBaseValue());
    entity.setSaturationFactor120QAxis(event.getSaturationFactor120QAxis());
    entity.setSaturationFactorQAxis(event.getSaturationFactorQAxis());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineDetailed(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineDetailed(entity);
  }

  /*
   * @param	event DeleteSynchronousMachineDetailedEvent
   */
  @EventHandler(payloadType = DeleteSynchronousMachineDetailedEvent.class)
  public void handle(DeleteSynchronousMachineDetailedEvent event) {
    LOGGER.info("handling DeleteSynchronousMachineDetailedEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    SynchronousMachineDetailed entity = delete(event.getSynchronousMachineDetailedId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineDetailed(entity);
  }

  /*
   * @param	event AssignEfdBaseRatioToSynchronousMachineDetailedEvent
   */
  @EventHandler(payloadType = AssignEfdBaseRatioToSynchronousMachineDetailedEvent.class)
  public void handle(AssignEfdBaseRatioToSynchronousMachineDetailedEvent event) {
    LOGGER.info("handling AssignEfdBaseRatioToSynchronousMachineDetailedEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachineDetailed entity =
        assignEfdBaseRatio(event.getSynchronousMachineDetailedId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineDetailed(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineDetailed(entity);
  }

  /*
   * @param	event UnAssignEfdBaseRatioFromSynchronousMachineDetailedEvent
   */
  @EventHandler(payloadType = UnAssignEfdBaseRatioFromSynchronousMachineDetailedEvent.class)
  public void handle(UnAssignEfdBaseRatioFromSynchronousMachineDetailedEvent event) {
    LOGGER.info("handling UnAssignEfdBaseRatioFromSynchronousMachineDetailedEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachineDetailed entity =
        unAssignEfdBaseRatio(event.getSynchronousMachineDetailedId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineDetailed(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineDetailed(entity);
  }

  /*
   * @param	event AssignIfdBaseValueToSynchronousMachineDetailedEvent
   */
  @EventHandler(payloadType = AssignIfdBaseValueToSynchronousMachineDetailedEvent.class)
  public void handle(AssignIfdBaseValueToSynchronousMachineDetailedEvent event) {
    LOGGER.info("handling AssignIfdBaseValueToSynchronousMachineDetailedEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachineDetailed entity =
        assignIfdBaseValue(event.getSynchronousMachineDetailedId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineDetailed(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineDetailed(entity);
  }

  /*
   * @param	event UnAssignIfdBaseValueFromSynchronousMachineDetailedEvent
   */
  @EventHandler(payloadType = UnAssignIfdBaseValueFromSynchronousMachineDetailedEvent.class)
  public void handle(UnAssignIfdBaseValueFromSynchronousMachineDetailedEvent event) {
    LOGGER.info("handling UnAssignIfdBaseValueFromSynchronousMachineDetailedEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachineDetailed entity =
        unAssignIfdBaseValue(event.getSynchronousMachineDetailedId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineDetailed(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineDetailed(entity);
  }

  /*
   * @param	event AssignSaturationFactor120QAxisToSynchronousMachineDetailedEvent
   */
  @EventHandler(payloadType = AssignSaturationFactor120QAxisToSynchronousMachineDetailedEvent.class)
  public void handle(AssignSaturationFactor120QAxisToSynchronousMachineDetailedEvent event) {
    LOGGER.info(
        "handling AssignSaturationFactor120QAxisToSynchronousMachineDetailedEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachineDetailed entity =
        assignSaturationFactor120QAxis(
            event.getSynchronousMachineDetailedId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineDetailed(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineDetailed(entity);
  }

  /*
   * @param	event UnAssignSaturationFactor120QAxisFromSynchronousMachineDetailedEvent
   */
  @EventHandler(
      payloadType = UnAssignSaturationFactor120QAxisFromSynchronousMachineDetailedEvent.class)
  public void handle(UnAssignSaturationFactor120QAxisFromSynchronousMachineDetailedEvent event) {
    LOGGER.info(
        "handling UnAssignSaturationFactor120QAxisFromSynchronousMachineDetailedEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachineDetailed entity =
        unAssignSaturationFactor120QAxis(event.getSynchronousMachineDetailedId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineDetailed(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineDetailed(entity);
  }

  /*
   * @param	event AssignSaturationFactorQAxisToSynchronousMachineDetailedEvent
   */
  @EventHandler(payloadType = AssignSaturationFactorQAxisToSynchronousMachineDetailedEvent.class)
  public void handle(AssignSaturationFactorQAxisToSynchronousMachineDetailedEvent event) {
    LOGGER.info("handling AssignSaturationFactorQAxisToSynchronousMachineDetailedEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SynchronousMachineDetailed entity =
        assignSaturationFactorQAxis(event.getSynchronousMachineDetailedId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineDetailed(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineDetailed(entity);
  }

  /*
   * @param	event UnAssignSaturationFactorQAxisFromSynchronousMachineDetailedEvent
   */
  @EventHandler(
      payloadType = UnAssignSaturationFactorQAxisFromSynchronousMachineDetailedEvent.class)
  public void handle(UnAssignSaturationFactorQAxisFromSynchronousMachineDetailedEvent event) {
    LOGGER.info(
        "handling UnAssignSaturationFactorQAxisFromSynchronousMachineDetailedEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SynchronousMachineDetailed entity =
        unAssignSaturationFactorQAxis(event.getSynchronousMachineDetailedId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSynchronousMachineDetailed(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSynchronousMachineDetailed(entity);
  }

  /**
   * Method to retrieve the SynchronousMachineDetailed via an SynchronousMachineDetailedPrimaryKey.
   *
   * @param id Long
   * @return SynchronousMachineDetailed
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public SynchronousMachineDetailed handle(FindSynchronousMachineDetailedQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getSynchronousMachineDetailedId());
  }

  /**
   * Method to retrieve a collection of all SynchronousMachineDetaileds
   *
   * @param query FindAllSynchronousMachineDetailedQuery
   * @return List<SynchronousMachineDetailed>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<SynchronousMachineDetailed> handle(FindAllSynchronousMachineDetailedQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindSynchronousMachineDetailed, but only if the id matches
   *
   * @param entity SynchronousMachineDetailed
   */
  protected void emitFindSynchronousMachineDetailed(SynchronousMachineDetailed entity) {
    LOGGER.info("handling emitFindSynchronousMachineDetailed");

    queryUpdateEmitter.emit(
        FindSynchronousMachineDetailedQuery.class,
        query ->
            query
                .getFilter()
                .getSynchronousMachineDetailedId()
                .equals(entity.getSynchronousMachineDetailedId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllSynchronousMachineDetailed
   *
   * @param entity SynchronousMachineDetailed
   */
  protected void emitFindAllSynchronousMachineDetailed(SynchronousMachineDetailed entity) {
    LOGGER.info("handling emitFindAllSynchronousMachineDetailed");

    queryUpdateEmitter.emit(FindAllSynchronousMachineDetailedQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(SynchronousMachineDetailedProjector.class.getName());
}
