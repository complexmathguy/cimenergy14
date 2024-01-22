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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.overexcitationlimiterdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.overexcitationlimiterdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for OverexcLimIEEE as outlined for the CQRS pattern. All event handling and query
 * handling related to OverexcLimIEEE are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by OverexcLimIEEEAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("overexcLimIEEE")
@Component("overexcLimIEEE-projector")
public class OverexcLimIEEEProjector extends OverexcLimIEEEEntityProjector {

  // core constructor
  public OverexcLimIEEEProjector(
      OverexcLimIEEERepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateOverexcLimIEEEEvent
   */
  @EventHandler(payloadType = CreateOverexcLimIEEEEvent.class)
  public void handle(CreateOverexcLimIEEEEvent event) {
    LOGGER.info("handling CreateOverexcLimIEEEEvent - " + event);
    OverexcLimIEEE entity = new OverexcLimIEEE();
    entity.setOverexcLimIEEEId(event.getOverexcLimIEEEId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimIEEE(entity);
  }

  /*
   * @param	event UpdateOverexcLimIEEEEvent
   */
  @EventHandler(payloadType = UpdateOverexcLimIEEEEvent.class)
  public void handle(UpdateOverexcLimIEEEEvent event) {
    LOGGER.info("handling UpdateOverexcLimIEEEEvent - " + event);

    OverexcLimIEEE entity = new OverexcLimIEEE();
    entity.setOverexcLimIEEEId(event.getOverexcLimIEEEId());
    entity.setHyst(event.getHyst());
    entity.setIfdlim(event.getIfdlim());
    entity.setIfdmax(event.getIfdmax());
    entity.setItfpu(event.getItfpu());
    entity.setKcd(event.getKcd());
    entity.setKramp(event.getKramp());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimIEEE(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimIEEE(entity);
  }

  /*
   * @param	event DeleteOverexcLimIEEEEvent
   */
  @EventHandler(payloadType = DeleteOverexcLimIEEEEvent.class)
  public void handle(DeleteOverexcLimIEEEEvent event) {
    LOGGER.info("handling DeleteOverexcLimIEEEEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    OverexcLimIEEE entity = delete(event.getOverexcLimIEEEId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimIEEE(entity);
  }

  /*
   * @param	event AssignHystToOverexcLimIEEEEvent
   */
  @EventHandler(payloadType = AssignHystToOverexcLimIEEEEvent.class)
  public void handle(AssignHystToOverexcLimIEEEEvent event) {
    LOGGER.info("handling AssignHystToOverexcLimIEEEEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    OverexcLimIEEE entity = assignHyst(event.getOverexcLimIEEEId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimIEEE(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimIEEE(entity);
  }

  /*
   * @param	event UnAssignHystFromOverexcLimIEEEEvent
   */
  @EventHandler(payloadType = UnAssignHystFromOverexcLimIEEEEvent.class)
  public void handle(UnAssignHystFromOverexcLimIEEEEvent event) {
    LOGGER.info("handling UnAssignHystFromOverexcLimIEEEEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    OverexcLimIEEE entity = unAssignHyst(event.getOverexcLimIEEEId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimIEEE(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimIEEE(entity);
  }

  /*
   * @param	event AssignIfdlimToOverexcLimIEEEEvent
   */
  @EventHandler(payloadType = AssignIfdlimToOverexcLimIEEEEvent.class)
  public void handle(AssignIfdlimToOverexcLimIEEEEvent event) {
    LOGGER.info("handling AssignIfdlimToOverexcLimIEEEEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    OverexcLimIEEE entity = assignIfdlim(event.getOverexcLimIEEEId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimIEEE(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimIEEE(entity);
  }

  /*
   * @param	event UnAssignIfdlimFromOverexcLimIEEEEvent
   */
  @EventHandler(payloadType = UnAssignIfdlimFromOverexcLimIEEEEvent.class)
  public void handle(UnAssignIfdlimFromOverexcLimIEEEEvent event) {
    LOGGER.info("handling UnAssignIfdlimFromOverexcLimIEEEEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    OverexcLimIEEE entity = unAssignIfdlim(event.getOverexcLimIEEEId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimIEEE(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimIEEE(entity);
  }

  /*
   * @param	event AssignIfdmaxToOverexcLimIEEEEvent
   */
  @EventHandler(payloadType = AssignIfdmaxToOverexcLimIEEEEvent.class)
  public void handle(AssignIfdmaxToOverexcLimIEEEEvent event) {
    LOGGER.info("handling AssignIfdmaxToOverexcLimIEEEEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    OverexcLimIEEE entity = assignIfdmax(event.getOverexcLimIEEEId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimIEEE(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimIEEE(entity);
  }

  /*
   * @param	event UnAssignIfdmaxFromOverexcLimIEEEEvent
   */
  @EventHandler(payloadType = UnAssignIfdmaxFromOverexcLimIEEEEvent.class)
  public void handle(UnAssignIfdmaxFromOverexcLimIEEEEvent event) {
    LOGGER.info("handling UnAssignIfdmaxFromOverexcLimIEEEEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    OverexcLimIEEE entity = unAssignIfdmax(event.getOverexcLimIEEEId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimIEEE(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimIEEE(entity);
  }

  /*
   * @param	event AssignItfpuToOverexcLimIEEEEvent
   */
  @EventHandler(payloadType = AssignItfpuToOverexcLimIEEEEvent.class)
  public void handle(AssignItfpuToOverexcLimIEEEEvent event) {
    LOGGER.info("handling AssignItfpuToOverexcLimIEEEEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    OverexcLimIEEE entity = assignItfpu(event.getOverexcLimIEEEId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimIEEE(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimIEEE(entity);
  }

  /*
   * @param	event UnAssignItfpuFromOverexcLimIEEEEvent
   */
  @EventHandler(payloadType = UnAssignItfpuFromOverexcLimIEEEEvent.class)
  public void handle(UnAssignItfpuFromOverexcLimIEEEEvent event) {
    LOGGER.info("handling UnAssignItfpuFromOverexcLimIEEEEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    OverexcLimIEEE entity = unAssignItfpu(event.getOverexcLimIEEEId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimIEEE(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimIEEE(entity);
  }

  /*
   * @param	event AssignKcdToOverexcLimIEEEEvent
   */
  @EventHandler(payloadType = AssignKcdToOverexcLimIEEEEvent.class)
  public void handle(AssignKcdToOverexcLimIEEEEvent event) {
    LOGGER.info("handling AssignKcdToOverexcLimIEEEEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    OverexcLimIEEE entity = assignKcd(event.getOverexcLimIEEEId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimIEEE(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimIEEE(entity);
  }

  /*
   * @param	event UnAssignKcdFromOverexcLimIEEEEvent
   */
  @EventHandler(payloadType = UnAssignKcdFromOverexcLimIEEEEvent.class)
  public void handle(UnAssignKcdFromOverexcLimIEEEEvent event) {
    LOGGER.info("handling UnAssignKcdFromOverexcLimIEEEEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    OverexcLimIEEE entity = unAssignKcd(event.getOverexcLimIEEEId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimIEEE(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimIEEE(entity);
  }

  /*
   * @param	event AssignKrampToOverexcLimIEEEEvent
   */
  @EventHandler(payloadType = AssignKrampToOverexcLimIEEEEvent.class)
  public void handle(AssignKrampToOverexcLimIEEEEvent event) {
    LOGGER.info("handling AssignKrampToOverexcLimIEEEEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    OverexcLimIEEE entity = assignKramp(event.getOverexcLimIEEEId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimIEEE(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimIEEE(entity);
  }

  /*
   * @param	event UnAssignKrampFromOverexcLimIEEEEvent
   */
  @EventHandler(payloadType = UnAssignKrampFromOverexcLimIEEEEvent.class)
  public void handle(UnAssignKrampFromOverexcLimIEEEEvent event) {
    LOGGER.info("handling UnAssignKrampFromOverexcLimIEEEEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    OverexcLimIEEE entity = unAssignKramp(event.getOverexcLimIEEEId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimIEEE(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimIEEE(entity);
  }

  /**
   * Method to retrieve the OverexcLimIEEE via an OverexcLimIEEEPrimaryKey.
   *
   * @param id Long
   * @return OverexcLimIEEE
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public OverexcLimIEEE handle(FindOverexcLimIEEEQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getOverexcLimIEEEId());
  }

  /**
   * Method to retrieve a collection of all OverexcLimIEEEs
   *
   * @param query FindAllOverexcLimIEEEQuery
   * @return List<OverexcLimIEEE>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<OverexcLimIEEE> handle(FindAllOverexcLimIEEEQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindOverexcLimIEEE, but only if the id matches
   *
   * @param entity OverexcLimIEEE
   */
  protected void emitFindOverexcLimIEEE(OverexcLimIEEE entity) {
    LOGGER.info("handling emitFindOverexcLimIEEE");

    queryUpdateEmitter.emit(
        FindOverexcLimIEEEQuery.class,
        query -> query.getFilter().getOverexcLimIEEEId().equals(entity.getOverexcLimIEEEId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllOverexcLimIEEE
   *
   * @param entity OverexcLimIEEE
   */
  protected void emitFindAllOverexcLimIEEE(OverexcLimIEEE entity) {
    LOGGER.info("handling emitFindAllOverexcLimIEEE");

    queryUpdateEmitter.emit(FindAllOverexcLimIEEEQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(OverexcLimIEEEProjector.class.getName());
}
