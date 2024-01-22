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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for GovSteamSGO as outlined for the CQRS pattern. All event handling and query handling
 * related to GovSteamSGO are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by GovSteamSGOAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("govSteamSGO")
@Component("govSteamSGO-projector")
public class GovSteamSGOProjector extends GovSteamSGOEntityProjector {

  // core constructor
  public GovSteamSGOProjector(
      GovSteamSGORepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateGovSteamSGOEvent
   */
  @EventHandler(payloadType = CreateGovSteamSGOEvent.class)
  public void handle(CreateGovSteamSGOEvent event) {
    LOGGER.info("handling CreateGovSteamSGOEvent - " + event);
    GovSteamSGO entity = new GovSteamSGO();
    entity.setGovSteamSGOId(event.getGovSteamSGOId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamSGO(entity);
  }

  /*
   * @param	event UpdateGovSteamSGOEvent
   */
  @EventHandler(payloadType = UpdateGovSteamSGOEvent.class)
  public void handle(UpdateGovSteamSGOEvent event) {
    LOGGER.info("handling UpdateGovSteamSGOEvent - " + event);

    GovSteamSGO entity = new GovSteamSGO();
    entity.setGovSteamSGOId(event.getGovSteamSGOId());
    entity.setK1(event.getK1());
    entity.setK2(event.getK2());
    entity.setK3(event.getK3());
    entity.setMwbase(event.getMwbase());
    entity.setPmax(event.getPmax());
    entity.setPmin(event.getPmin());
    entity.setT1(event.getT1());
    entity.setT2(event.getT2());
    entity.setT3(event.getT3());
    entity.setT4(event.getT4());
    entity.setT5(event.getT5());
    entity.setT6(event.getT6());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamSGO(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamSGO(entity);
  }

  /*
   * @param	event DeleteGovSteamSGOEvent
   */
  @EventHandler(payloadType = DeleteGovSteamSGOEvent.class)
  public void handle(DeleteGovSteamSGOEvent event) {
    LOGGER.info("handling DeleteGovSteamSGOEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    GovSteamSGO entity = delete(event.getGovSteamSGOId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamSGO(entity);
  }

  /*
   * @param	event AssignK1ToGovSteamSGOEvent
   */
  @EventHandler(payloadType = AssignK1ToGovSteamSGOEvent.class)
  public void handle(AssignK1ToGovSteamSGOEvent event) {
    LOGGER.info("handling AssignK1ToGovSteamSGOEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamSGO entity = assignK1(event.getGovSteamSGOId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamSGO(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamSGO(entity);
  }

  /*
   * @param	event UnAssignK1FromGovSteamSGOEvent
   */
  @EventHandler(payloadType = UnAssignK1FromGovSteamSGOEvent.class)
  public void handle(UnAssignK1FromGovSteamSGOEvent event) {
    LOGGER.info("handling UnAssignK1FromGovSteamSGOEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamSGO entity = unAssignK1(event.getGovSteamSGOId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamSGO(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamSGO(entity);
  }

  /*
   * @param	event AssignK2ToGovSteamSGOEvent
   */
  @EventHandler(payloadType = AssignK2ToGovSteamSGOEvent.class)
  public void handle(AssignK2ToGovSteamSGOEvent event) {
    LOGGER.info("handling AssignK2ToGovSteamSGOEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamSGO entity = assignK2(event.getGovSteamSGOId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamSGO(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamSGO(entity);
  }

  /*
   * @param	event UnAssignK2FromGovSteamSGOEvent
   */
  @EventHandler(payloadType = UnAssignK2FromGovSteamSGOEvent.class)
  public void handle(UnAssignK2FromGovSteamSGOEvent event) {
    LOGGER.info("handling UnAssignK2FromGovSteamSGOEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamSGO entity = unAssignK2(event.getGovSteamSGOId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamSGO(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamSGO(entity);
  }

  /*
   * @param	event AssignK3ToGovSteamSGOEvent
   */
  @EventHandler(payloadType = AssignK3ToGovSteamSGOEvent.class)
  public void handle(AssignK3ToGovSteamSGOEvent event) {
    LOGGER.info("handling AssignK3ToGovSteamSGOEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamSGO entity = assignK3(event.getGovSteamSGOId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamSGO(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamSGO(entity);
  }

  /*
   * @param	event UnAssignK3FromGovSteamSGOEvent
   */
  @EventHandler(payloadType = UnAssignK3FromGovSteamSGOEvent.class)
  public void handle(UnAssignK3FromGovSteamSGOEvent event) {
    LOGGER.info("handling UnAssignK3FromGovSteamSGOEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamSGO entity = unAssignK3(event.getGovSteamSGOId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamSGO(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamSGO(entity);
  }

  /*
   * @param	event AssignMwbaseToGovSteamSGOEvent
   */
  @EventHandler(payloadType = AssignMwbaseToGovSteamSGOEvent.class)
  public void handle(AssignMwbaseToGovSteamSGOEvent event) {
    LOGGER.info("handling AssignMwbaseToGovSteamSGOEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamSGO entity = assignMwbase(event.getGovSteamSGOId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamSGO(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamSGO(entity);
  }

  /*
   * @param	event UnAssignMwbaseFromGovSteamSGOEvent
   */
  @EventHandler(payloadType = UnAssignMwbaseFromGovSteamSGOEvent.class)
  public void handle(UnAssignMwbaseFromGovSteamSGOEvent event) {
    LOGGER.info("handling UnAssignMwbaseFromGovSteamSGOEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamSGO entity = unAssignMwbase(event.getGovSteamSGOId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamSGO(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamSGO(entity);
  }

  /*
   * @param	event AssignPmaxToGovSteamSGOEvent
   */
  @EventHandler(payloadType = AssignPmaxToGovSteamSGOEvent.class)
  public void handle(AssignPmaxToGovSteamSGOEvent event) {
    LOGGER.info("handling AssignPmaxToGovSteamSGOEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamSGO entity = assignPmax(event.getGovSteamSGOId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamSGO(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamSGO(entity);
  }

  /*
   * @param	event UnAssignPmaxFromGovSteamSGOEvent
   */
  @EventHandler(payloadType = UnAssignPmaxFromGovSteamSGOEvent.class)
  public void handle(UnAssignPmaxFromGovSteamSGOEvent event) {
    LOGGER.info("handling UnAssignPmaxFromGovSteamSGOEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamSGO entity = unAssignPmax(event.getGovSteamSGOId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamSGO(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamSGO(entity);
  }

  /*
   * @param	event AssignPminToGovSteamSGOEvent
   */
  @EventHandler(payloadType = AssignPminToGovSteamSGOEvent.class)
  public void handle(AssignPminToGovSteamSGOEvent event) {
    LOGGER.info("handling AssignPminToGovSteamSGOEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamSGO entity = assignPmin(event.getGovSteamSGOId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamSGO(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamSGO(entity);
  }

  /*
   * @param	event UnAssignPminFromGovSteamSGOEvent
   */
  @EventHandler(payloadType = UnAssignPminFromGovSteamSGOEvent.class)
  public void handle(UnAssignPminFromGovSteamSGOEvent event) {
    LOGGER.info("handling UnAssignPminFromGovSteamSGOEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamSGO entity = unAssignPmin(event.getGovSteamSGOId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamSGO(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamSGO(entity);
  }

  /*
   * @param	event AssignT1ToGovSteamSGOEvent
   */
  @EventHandler(payloadType = AssignT1ToGovSteamSGOEvent.class)
  public void handle(AssignT1ToGovSteamSGOEvent event) {
    LOGGER.info("handling AssignT1ToGovSteamSGOEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamSGO entity = assignT1(event.getGovSteamSGOId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamSGO(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamSGO(entity);
  }

  /*
   * @param	event UnAssignT1FromGovSteamSGOEvent
   */
  @EventHandler(payloadType = UnAssignT1FromGovSteamSGOEvent.class)
  public void handle(UnAssignT1FromGovSteamSGOEvent event) {
    LOGGER.info("handling UnAssignT1FromGovSteamSGOEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamSGO entity = unAssignT1(event.getGovSteamSGOId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamSGO(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamSGO(entity);
  }

  /*
   * @param	event AssignT2ToGovSteamSGOEvent
   */
  @EventHandler(payloadType = AssignT2ToGovSteamSGOEvent.class)
  public void handle(AssignT2ToGovSteamSGOEvent event) {
    LOGGER.info("handling AssignT2ToGovSteamSGOEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamSGO entity = assignT2(event.getGovSteamSGOId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamSGO(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamSGO(entity);
  }

  /*
   * @param	event UnAssignT2FromGovSteamSGOEvent
   */
  @EventHandler(payloadType = UnAssignT2FromGovSteamSGOEvent.class)
  public void handle(UnAssignT2FromGovSteamSGOEvent event) {
    LOGGER.info("handling UnAssignT2FromGovSteamSGOEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamSGO entity = unAssignT2(event.getGovSteamSGOId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamSGO(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamSGO(entity);
  }

  /*
   * @param	event AssignT3ToGovSteamSGOEvent
   */
  @EventHandler(payloadType = AssignT3ToGovSteamSGOEvent.class)
  public void handle(AssignT3ToGovSteamSGOEvent event) {
    LOGGER.info("handling AssignT3ToGovSteamSGOEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamSGO entity = assignT3(event.getGovSteamSGOId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamSGO(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamSGO(entity);
  }

  /*
   * @param	event UnAssignT3FromGovSteamSGOEvent
   */
  @EventHandler(payloadType = UnAssignT3FromGovSteamSGOEvent.class)
  public void handle(UnAssignT3FromGovSteamSGOEvent event) {
    LOGGER.info("handling UnAssignT3FromGovSteamSGOEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamSGO entity = unAssignT3(event.getGovSteamSGOId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamSGO(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamSGO(entity);
  }

  /*
   * @param	event AssignT4ToGovSteamSGOEvent
   */
  @EventHandler(payloadType = AssignT4ToGovSteamSGOEvent.class)
  public void handle(AssignT4ToGovSteamSGOEvent event) {
    LOGGER.info("handling AssignT4ToGovSteamSGOEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamSGO entity = assignT4(event.getGovSteamSGOId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamSGO(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamSGO(entity);
  }

  /*
   * @param	event UnAssignT4FromGovSteamSGOEvent
   */
  @EventHandler(payloadType = UnAssignT4FromGovSteamSGOEvent.class)
  public void handle(UnAssignT4FromGovSteamSGOEvent event) {
    LOGGER.info("handling UnAssignT4FromGovSteamSGOEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamSGO entity = unAssignT4(event.getGovSteamSGOId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamSGO(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamSGO(entity);
  }

  /*
   * @param	event AssignT5ToGovSteamSGOEvent
   */
  @EventHandler(payloadType = AssignT5ToGovSteamSGOEvent.class)
  public void handle(AssignT5ToGovSteamSGOEvent event) {
    LOGGER.info("handling AssignT5ToGovSteamSGOEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamSGO entity = assignT5(event.getGovSteamSGOId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamSGO(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamSGO(entity);
  }

  /*
   * @param	event UnAssignT5FromGovSteamSGOEvent
   */
  @EventHandler(payloadType = UnAssignT5FromGovSteamSGOEvent.class)
  public void handle(UnAssignT5FromGovSteamSGOEvent event) {
    LOGGER.info("handling UnAssignT5FromGovSteamSGOEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamSGO entity = unAssignT5(event.getGovSteamSGOId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamSGO(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamSGO(entity);
  }

  /*
   * @param	event AssignT6ToGovSteamSGOEvent
   */
  @EventHandler(payloadType = AssignT6ToGovSteamSGOEvent.class)
  public void handle(AssignT6ToGovSteamSGOEvent event) {
    LOGGER.info("handling AssignT6ToGovSteamSGOEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamSGO entity = assignT6(event.getGovSteamSGOId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamSGO(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamSGO(entity);
  }

  /*
   * @param	event UnAssignT6FromGovSteamSGOEvent
   */
  @EventHandler(payloadType = UnAssignT6FromGovSteamSGOEvent.class)
  public void handle(UnAssignT6FromGovSteamSGOEvent event) {
    LOGGER.info("handling UnAssignT6FromGovSteamSGOEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamSGO entity = unAssignT6(event.getGovSteamSGOId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamSGO(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamSGO(entity);
  }

  /**
   * Method to retrieve the GovSteamSGO via an GovSteamSGOPrimaryKey.
   *
   * @param id Long
   * @return GovSteamSGO
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public GovSteamSGO handle(FindGovSteamSGOQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getGovSteamSGOId());
  }

  /**
   * Method to retrieve a collection of all GovSteamSGOs
   *
   * @param query FindAllGovSteamSGOQuery
   * @return List<GovSteamSGO>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<GovSteamSGO> handle(FindAllGovSteamSGOQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindGovSteamSGO, but only if the id matches
   *
   * @param entity GovSteamSGO
   */
  protected void emitFindGovSteamSGO(GovSteamSGO entity) {
    LOGGER.info("handling emitFindGovSteamSGO");

    queryUpdateEmitter.emit(
        FindGovSteamSGOQuery.class,
        query -> query.getFilter().getGovSteamSGOId().equals(entity.getGovSteamSGOId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllGovSteamSGO
   *
   * @param entity GovSteamSGO
   */
  protected void emitFindAllGovSteamSGO(GovSteamSGO entity) {
    LOGGER.info("handling emitFindAllGovSteamSGO");

    queryUpdateEmitter.emit(FindAllGovSteamSGOQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(GovSteamSGOProjector.class.getName());
}
