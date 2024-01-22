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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.underexcitationlimiterdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.underexcitationlimiterdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for UnderexcLim2Simplified as outlined for the CQRS pattern. All event handling and
 * query handling related to UnderexcLim2Simplified are invoked here and dispersed as an event to be
 * handled elsewhere.
 *
 * <p>Commands are handled by UnderexcLim2SimplifiedAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("underexcLim2Simplified")
@Component("underexcLim2Simplified-projector")
public class UnderexcLim2SimplifiedProjector extends UnderexcLim2SimplifiedEntityProjector {

  // core constructor
  public UnderexcLim2SimplifiedProjector(
      UnderexcLim2SimplifiedRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateUnderexcLim2SimplifiedEvent
   */
  @EventHandler(payloadType = CreateUnderexcLim2SimplifiedEvent.class)
  public void handle(CreateUnderexcLim2SimplifiedEvent event) {
    LOGGER.info("handling CreateUnderexcLim2SimplifiedEvent - " + event);
    UnderexcLim2Simplified entity = new UnderexcLim2Simplified();
    entity.setUnderexcLim2SimplifiedId(event.getUnderexcLim2SimplifiedId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLim2Simplified(entity);
  }

  /*
   * @param	event UpdateUnderexcLim2SimplifiedEvent
   */
  @EventHandler(payloadType = UpdateUnderexcLim2SimplifiedEvent.class)
  public void handle(UpdateUnderexcLim2SimplifiedEvent event) {
    LOGGER.info("handling UpdateUnderexcLim2SimplifiedEvent - " + event);

    UnderexcLim2Simplified entity = new UnderexcLim2Simplified();
    entity.setUnderexcLim2SimplifiedId(event.getUnderexcLim2SimplifiedId());
    entity.setKui(event.getKui());
    entity.setP0(event.getP0());
    entity.setP1(event.getP1());
    entity.setQ0(event.getQ0());
    entity.setQ1(event.getQ1());
    entity.setVuimax(event.getVuimax());
    entity.setVuimin(event.getVuimin());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLim2Simplified(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLim2Simplified(entity);
  }

  /*
   * @param	event DeleteUnderexcLim2SimplifiedEvent
   */
  @EventHandler(payloadType = DeleteUnderexcLim2SimplifiedEvent.class)
  public void handle(DeleteUnderexcLim2SimplifiedEvent event) {
    LOGGER.info("handling DeleteUnderexcLim2SimplifiedEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    UnderexcLim2Simplified entity = delete(event.getUnderexcLim2SimplifiedId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLim2Simplified(entity);
  }

  /*
   * @param	event AssignKuiToUnderexcLim2SimplifiedEvent
   */
  @EventHandler(payloadType = AssignKuiToUnderexcLim2SimplifiedEvent.class)
  public void handle(AssignKuiToUnderexcLim2SimplifiedEvent event) {
    LOGGER.info("handling AssignKuiToUnderexcLim2SimplifiedEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLim2Simplified entity =
        assignKui(event.getUnderexcLim2SimplifiedId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLim2Simplified(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLim2Simplified(entity);
  }

  /*
   * @param	event UnAssignKuiFromUnderexcLim2SimplifiedEvent
   */
  @EventHandler(payloadType = UnAssignKuiFromUnderexcLim2SimplifiedEvent.class)
  public void handle(UnAssignKuiFromUnderexcLim2SimplifiedEvent event) {
    LOGGER.info("handling UnAssignKuiFromUnderexcLim2SimplifiedEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLim2Simplified entity = unAssignKui(event.getUnderexcLim2SimplifiedId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLim2Simplified(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLim2Simplified(entity);
  }

  /*
   * @param	event AssignP0ToUnderexcLim2SimplifiedEvent
   */
  @EventHandler(payloadType = AssignP0ToUnderexcLim2SimplifiedEvent.class)
  public void handle(AssignP0ToUnderexcLim2SimplifiedEvent event) {
    LOGGER.info("handling AssignP0ToUnderexcLim2SimplifiedEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLim2Simplified entity =
        assignP0(event.getUnderexcLim2SimplifiedId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLim2Simplified(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLim2Simplified(entity);
  }

  /*
   * @param	event UnAssignP0FromUnderexcLim2SimplifiedEvent
   */
  @EventHandler(payloadType = UnAssignP0FromUnderexcLim2SimplifiedEvent.class)
  public void handle(UnAssignP0FromUnderexcLim2SimplifiedEvent event) {
    LOGGER.info("handling UnAssignP0FromUnderexcLim2SimplifiedEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLim2Simplified entity = unAssignP0(event.getUnderexcLim2SimplifiedId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLim2Simplified(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLim2Simplified(entity);
  }

  /*
   * @param	event AssignP1ToUnderexcLim2SimplifiedEvent
   */
  @EventHandler(payloadType = AssignP1ToUnderexcLim2SimplifiedEvent.class)
  public void handle(AssignP1ToUnderexcLim2SimplifiedEvent event) {
    LOGGER.info("handling AssignP1ToUnderexcLim2SimplifiedEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLim2Simplified entity =
        assignP1(event.getUnderexcLim2SimplifiedId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLim2Simplified(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLim2Simplified(entity);
  }

  /*
   * @param	event UnAssignP1FromUnderexcLim2SimplifiedEvent
   */
  @EventHandler(payloadType = UnAssignP1FromUnderexcLim2SimplifiedEvent.class)
  public void handle(UnAssignP1FromUnderexcLim2SimplifiedEvent event) {
    LOGGER.info("handling UnAssignP1FromUnderexcLim2SimplifiedEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLim2Simplified entity = unAssignP1(event.getUnderexcLim2SimplifiedId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLim2Simplified(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLim2Simplified(entity);
  }

  /*
   * @param	event AssignQ0ToUnderexcLim2SimplifiedEvent
   */
  @EventHandler(payloadType = AssignQ0ToUnderexcLim2SimplifiedEvent.class)
  public void handle(AssignQ0ToUnderexcLim2SimplifiedEvent event) {
    LOGGER.info("handling AssignQ0ToUnderexcLim2SimplifiedEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLim2Simplified entity =
        assignQ0(event.getUnderexcLim2SimplifiedId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLim2Simplified(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLim2Simplified(entity);
  }

  /*
   * @param	event UnAssignQ0FromUnderexcLim2SimplifiedEvent
   */
  @EventHandler(payloadType = UnAssignQ0FromUnderexcLim2SimplifiedEvent.class)
  public void handle(UnAssignQ0FromUnderexcLim2SimplifiedEvent event) {
    LOGGER.info("handling UnAssignQ0FromUnderexcLim2SimplifiedEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLim2Simplified entity = unAssignQ0(event.getUnderexcLim2SimplifiedId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLim2Simplified(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLim2Simplified(entity);
  }

  /*
   * @param	event AssignQ1ToUnderexcLim2SimplifiedEvent
   */
  @EventHandler(payloadType = AssignQ1ToUnderexcLim2SimplifiedEvent.class)
  public void handle(AssignQ1ToUnderexcLim2SimplifiedEvent event) {
    LOGGER.info("handling AssignQ1ToUnderexcLim2SimplifiedEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLim2Simplified entity =
        assignQ1(event.getUnderexcLim2SimplifiedId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLim2Simplified(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLim2Simplified(entity);
  }

  /*
   * @param	event UnAssignQ1FromUnderexcLim2SimplifiedEvent
   */
  @EventHandler(payloadType = UnAssignQ1FromUnderexcLim2SimplifiedEvent.class)
  public void handle(UnAssignQ1FromUnderexcLim2SimplifiedEvent event) {
    LOGGER.info("handling UnAssignQ1FromUnderexcLim2SimplifiedEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLim2Simplified entity = unAssignQ1(event.getUnderexcLim2SimplifiedId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLim2Simplified(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLim2Simplified(entity);
  }

  /*
   * @param	event AssignVuimaxToUnderexcLim2SimplifiedEvent
   */
  @EventHandler(payloadType = AssignVuimaxToUnderexcLim2SimplifiedEvent.class)
  public void handle(AssignVuimaxToUnderexcLim2SimplifiedEvent event) {
    LOGGER.info("handling AssignVuimaxToUnderexcLim2SimplifiedEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLim2Simplified entity =
        assignVuimax(event.getUnderexcLim2SimplifiedId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLim2Simplified(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLim2Simplified(entity);
  }

  /*
   * @param	event UnAssignVuimaxFromUnderexcLim2SimplifiedEvent
   */
  @EventHandler(payloadType = UnAssignVuimaxFromUnderexcLim2SimplifiedEvent.class)
  public void handle(UnAssignVuimaxFromUnderexcLim2SimplifiedEvent event) {
    LOGGER.info("handling UnAssignVuimaxFromUnderexcLim2SimplifiedEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLim2Simplified entity = unAssignVuimax(event.getUnderexcLim2SimplifiedId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLim2Simplified(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLim2Simplified(entity);
  }

  /*
   * @param	event AssignVuiminToUnderexcLim2SimplifiedEvent
   */
  @EventHandler(payloadType = AssignVuiminToUnderexcLim2SimplifiedEvent.class)
  public void handle(AssignVuiminToUnderexcLim2SimplifiedEvent event) {
    LOGGER.info("handling AssignVuiminToUnderexcLim2SimplifiedEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLim2Simplified entity =
        assignVuimin(event.getUnderexcLim2SimplifiedId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLim2Simplified(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLim2Simplified(entity);
  }

  /*
   * @param	event UnAssignVuiminFromUnderexcLim2SimplifiedEvent
   */
  @EventHandler(payloadType = UnAssignVuiminFromUnderexcLim2SimplifiedEvent.class)
  public void handle(UnAssignVuiminFromUnderexcLim2SimplifiedEvent event) {
    LOGGER.info("handling UnAssignVuiminFromUnderexcLim2SimplifiedEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLim2Simplified entity = unAssignVuimin(event.getUnderexcLim2SimplifiedId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLim2Simplified(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLim2Simplified(entity);
  }

  /**
   * Method to retrieve the UnderexcLim2Simplified via an UnderexcLim2SimplifiedPrimaryKey.
   *
   * @param id Long
   * @return UnderexcLim2Simplified
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public UnderexcLim2Simplified handle(FindUnderexcLim2SimplifiedQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getUnderexcLim2SimplifiedId());
  }

  /**
   * Method to retrieve a collection of all UnderexcLim2Simplifieds
   *
   * @param query FindAllUnderexcLim2SimplifiedQuery
   * @return List<UnderexcLim2Simplified>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<UnderexcLim2Simplified> handle(FindAllUnderexcLim2SimplifiedQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindUnderexcLim2Simplified, but only if the id matches
   *
   * @param entity UnderexcLim2Simplified
   */
  protected void emitFindUnderexcLim2Simplified(UnderexcLim2Simplified entity) {
    LOGGER.info("handling emitFindUnderexcLim2Simplified");

    queryUpdateEmitter.emit(
        FindUnderexcLim2SimplifiedQuery.class,
        query ->
            query
                .getFilter()
                .getUnderexcLim2SimplifiedId()
                .equals(entity.getUnderexcLim2SimplifiedId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllUnderexcLim2Simplified
   *
   * @param entity UnderexcLim2Simplified
   */
  protected void emitFindAllUnderexcLim2Simplified(UnderexcLim2Simplified entity) {
    LOGGER.info("handling emitFindAllUnderexcLim2Simplified");

    queryUpdateEmitter.emit(FindAllUnderexcLim2SimplifiedQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(UnderexcLim2SimplifiedProjector.class.getName());
}
