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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.loaddynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.loaddynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for LoadMotor as outlined for the CQRS pattern. All event handling and query handling
 * related to LoadMotor are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by LoadMotorAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("loadMotor")
@Component("loadMotor-projector")
public class LoadMotorProjector extends LoadMotorEntityProjector {

  // core constructor
  public LoadMotorProjector(LoadMotorRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateLoadMotorEvent
   */
  @EventHandler(payloadType = CreateLoadMotorEvent.class)
  public void handle(CreateLoadMotorEvent event) {
    LOGGER.info("handling CreateLoadMotorEvent - " + event);
    LoadMotor entity = new LoadMotor();
    entity.setLoadMotorId(event.getLoadMotorId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadMotor(entity);
  }

  /*
   * @param	event UpdateLoadMotorEvent
   */
  @EventHandler(payloadType = UpdateLoadMotorEvent.class)
  public void handle(UpdateLoadMotorEvent event) {
    LOGGER.info("handling UpdateLoadMotorEvent - " + event);

    LoadMotor entity = new LoadMotor();
    entity.setLoadMotorId(event.getLoadMotorId());
    entity.setD(event.getD());
    entity.setH(event.getH());
    entity.setLfac(event.getLfac());
    entity.setLp(event.getLp());
    entity.setLpp(event.getLpp());
    entity.setLs(event.getLs());
    entity.setPfrac(event.getPfrac());
    entity.setRa(event.getRa());
    entity.setTbkr(event.getTbkr());
    entity.setTpo(event.getTpo());
    entity.setTppo(event.getTppo());
    entity.setTv(event.getTv());
    entity.setVt(event.getVt());
    entity.setLoadMotor(event.getLoadMotor());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadMotor(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadMotor(entity);
  }

  /*
   * @param	event DeleteLoadMotorEvent
   */
  @EventHandler(payloadType = DeleteLoadMotorEvent.class)
  public void handle(DeleteLoadMotorEvent event) {
    LOGGER.info("handling DeleteLoadMotorEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    LoadMotor entity = delete(event.getLoadMotorId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadMotor(entity);
  }

  /*
   * @param	event AssignDToLoadMotorEvent
   */
  @EventHandler(payloadType = AssignDToLoadMotorEvent.class)
  public void handle(AssignDToLoadMotorEvent event) {
    LOGGER.info("handling AssignDToLoadMotorEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadMotor entity = assignD(event.getLoadMotorId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadMotor(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadMotor(entity);
  }

  /*
   * @param	event UnAssignDFromLoadMotorEvent
   */
  @EventHandler(payloadType = UnAssignDFromLoadMotorEvent.class)
  public void handle(UnAssignDFromLoadMotorEvent event) {
    LOGGER.info("handling UnAssignDFromLoadMotorEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadMotor entity = unAssignD(event.getLoadMotorId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadMotor(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadMotor(entity);
  }

  /*
   * @param	event AssignHToLoadMotorEvent
   */
  @EventHandler(payloadType = AssignHToLoadMotorEvent.class)
  public void handle(AssignHToLoadMotorEvent event) {
    LOGGER.info("handling AssignHToLoadMotorEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadMotor entity = assignH(event.getLoadMotorId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadMotor(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadMotor(entity);
  }

  /*
   * @param	event UnAssignHFromLoadMotorEvent
   */
  @EventHandler(payloadType = UnAssignHFromLoadMotorEvent.class)
  public void handle(UnAssignHFromLoadMotorEvent event) {
    LOGGER.info("handling UnAssignHFromLoadMotorEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadMotor entity = unAssignH(event.getLoadMotorId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadMotor(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadMotor(entity);
  }

  /*
   * @param	event AssignLfacToLoadMotorEvent
   */
  @EventHandler(payloadType = AssignLfacToLoadMotorEvent.class)
  public void handle(AssignLfacToLoadMotorEvent event) {
    LOGGER.info("handling AssignLfacToLoadMotorEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadMotor entity = assignLfac(event.getLoadMotorId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadMotor(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadMotor(entity);
  }

  /*
   * @param	event UnAssignLfacFromLoadMotorEvent
   */
  @EventHandler(payloadType = UnAssignLfacFromLoadMotorEvent.class)
  public void handle(UnAssignLfacFromLoadMotorEvent event) {
    LOGGER.info("handling UnAssignLfacFromLoadMotorEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadMotor entity = unAssignLfac(event.getLoadMotorId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadMotor(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadMotor(entity);
  }

  /*
   * @param	event AssignLpToLoadMotorEvent
   */
  @EventHandler(payloadType = AssignLpToLoadMotorEvent.class)
  public void handle(AssignLpToLoadMotorEvent event) {
    LOGGER.info("handling AssignLpToLoadMotorEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadMotor entity = assignLp(event.getLoadMotorId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadMotor(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadMotor(entity);
  }

  /*
   * @param	event UnAssignLpFromLoadMotorEvent
   */
  @EventHandler(payloadType = UnAssignLpFromLoadMotorEvent.class)
  public void handle(UnAssignLpFromLoadMotorEvent event) {
    LOGGER.info("handling UnAssignLpFromLoadMotorEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadMotor entity = unAssignLp(event.getLoadMotorId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadMotor(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadMotor(entity);
  }

  /*
   * @param	event AssignLppToLoadMotorEvent
   */
  @EventHandler(payloadType = AssignLppToLoadMotorEvent.class)
  public void handle(AssignLppToLoadMotorEvent event) {
    LOGGER.info("handling AssignLppToLoadMotorEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadMotor entity = assignLpp(event.getLoadMotorId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadMotor(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadMotor(entity);
  }

  /*
   * @param	event UnAssignLppFromLoadMotorEvent
   */
  @EventHandler(payloadType = UnAssignLppFromLoadMotorEvent.class)
  public void handle(UnAssignLppFromLoadMotorEvent event) {
    LOGGER.info("handling UnAssignLppFromLoadMotorEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadMotor entity = unAssignLpp(event.getLoadMotorId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadMotor(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadMotor(entity);
  }

  /*
   * @param	event AssignLsToLoadMotorEvent
   */
  @EventHandler(payloadType = AssignLsToLoadMotorEvent.class)
  public void handle(AssignLsToLoadMotorEvent event) {
    LOGGER.info("handling AssignLsToLoadMotorEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadMotor entity = assignLs(event.getLoadMotorId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadMotor(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadMotor(entity);
  }

  /*
   * @param	event UnAssignLsFromLoadMotorEvent
   */
  @EventHandler(payloadType = UnAssignLsFromLoadMotorEvent.class)
  public void handle(UnAssignLsFromLoadMotorEvent event) {
    LOGGER.info("handling UnAssignLsFromLoadMotorEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadMotor entity = unAssignLs(event.getLoadMotorId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadMotor(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadMotor(entity);
  }

  /*
   * @param	event AssignPfracToLoadMotorEvent
   */
  @EventHandler(payloadType = AssignPfracToLoadMotorEvent.class)
  public void handle(AssignPfracToLoadMotorEvent event) {
    LOGGER.info("handling AssignPfracToLoadMotorEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadMotor entity = assignPfrac(event.getLoadMotorId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadMotor(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadMotor(entity);
  }

  /*
   * @param	event UnAssignPfracFromLoadMotorEvent
   */
  @EventHandler(payloadType = UnAssignPfracFromLoadMotorEvent.class)
  public void handle(UnAssignPfracFromLoadMotorEvent event) {
    LOGGER.info("handling UnAssignPfracFromLoadMotorEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadMotor entity = unAssignPfrac(event.getLoadMotorId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadMotor(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadMotor(entity);
  }

  /*
   * @param	event AssignRaToLoadMotorEvent
   */
  @EventHandler(payloadType = AssignRaToLoadMotorEvent.class)
  public void handle(AssignRaToLoadMotorEvent event) {
    LOGGER.info("handling AssignRaToLoadMotorEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadMotor entity = assignRa(event.getLoadMotorId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadMotor(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadMotor(entity);
  }

  /*
   * @param	event UnAssignRaFromLoadMotorEvent
   */
  @EventHandler(payloadType = UnAssignRaFromLoadMotorEvent.class)
  public void handle(UnAssignRaFromLoadMotorEvent event) {
    LOGGER.info("handling UnAssignRaFromLoadMotorEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadMotor entity = unAssignRa(event.getLoadMotorId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadMotor(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadMotor(entity);
  }

  /*
   * @param	event AssignTbkrToLoadMotorEvent
   */
  @EventHandler(payloadType = AssignTbkrToLoadMotorEvent.class)
  public void handle(AssignTbkrToLoadMotorEvent event) {
    LOGGER.info("handling AssignTbkrToLoadMotorEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadMotor entity = assignTbkr(event.getLoadMotorId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadMotor(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadMotor(entity);
  }

  /*
   * @param	event UnAssignTbkrFromLoadMotorEvent
   */
  @EventHandler(payloadType = UnAssignTbkrFromLoadMotorEvent.class)
  public void handle(UnAssignTbkrFromLoadMotorEvent event) {
    LOGGER.info("handling UnAssignTbkrFromLoadMotorEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadMotor entity = unAssignTbkr(event.getLoadMotorId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadMotor(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadMotor(entity);
  }

  /*
   * @param	event AssignTpoToLoadMotorEvent
   */
  @EventHandler(payloadType = AssignTpoToLoadMotorEvent.class)
  public void handle(AssignTpoToLoadMotorEvent event) {
    LOGGER.info("handling AssignTpoToLoadMotorEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadMotor entity = assignTpo(event.getLoadMotorId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadMotor(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadMotor(entity);
  }

  /*
   * @param	event UnAssignTpoFromLoadMotorEvent
   */
  @EventHandler(payloadType = UnAssignTpoFromLoadMotorEvent.class)
  public void handle(UnAssignTpoFromLoadMotorEvent event) {
    LOGGER.info("handling UnAssignTpoFromLoadMotorEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadMotor entity = unAssignTpo(event.getLoadMotorId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadMotor(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadMotor(entity);
  }

  /*
   * @param	event AssignTppoToLoadMotorEvent
   */
  @EventHandler(payloadType = AssignTppoToLoadMotorEvent.class)
  public void handle(AssignTppoToLoadMotorEvent event) {
    LOGGER.info("handling AssignTppoToLoadMotorEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadMotor entity = assignTppo(event.getLoadMotorId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadMotor(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadMotor(entity);
  }

  /*
   * @param	event UnAssignTppoFromLoadMotorEvent
   */
  @EventHandler(payloadType = UnAssignTppoFromLoadMotorEvent.class)
  public void handle(UnAssignTppoFromLoadMotorEvent event) {
    LOGGER.info("handling UnAssignTppoFromLoadMotorEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadMotor entity = unAssignTppo(event.getLoadMotorId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadMotor(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadMotor(entity);
  }

  /*
   * @param	event AssignTvToLoadMotorEvent
   */
  @EventHandler(payloadType = AssignTvToLoadMotorEvent.class)
  public void handle(AssignTvToLoadMotorEvent event) {
    LOGGER.info("handling AssignTvToLoadMotorEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadMotor entity = assignTv(event.getLoadMotorId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadMotor(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadMotor(entity);
  }

  /*
   * @param	event UnAssignTvFromLoadMotorEvent
   */
  @EventHandler(payloadType = UnAssignTvFromLoadMotorEvent.class)
  public void handle(UnAssignTvFromLoadMotorEvent event) {
    LOGGER.info("handling UnAssignTvFromLoadMotorEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadMotor entity = unAssignTv(event.getLoadMotorId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadMotor(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadMotor(entity);
  }

  /*
   * @param	event AssignVtToLoadMotorEvent
   */
  @EventHandler(payloadType = AssignVtToLoadMotorEvent.class)
  public void handle(AssignVtToLoadMotorEvent event) {
    LOGGER.info("handling AssignVtToLoadMotorEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadMotor entity = assignVt(event.getLoadMotorId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadMotor(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadMotor(entity);
  }

  /*
   * @param	event UnAssignVtFromLoadMotorEvent
   */
  @EventHandler(payloadType = UnAssignVtFromLoadMotorEvent.class)
  public void handle(UnAssignVtFromLoadMotorEvent event) {
    LOGGER.info("handling UnAssignVtFromLoadMotorEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadMotor entity = unAssignVt(event.getLoadMotorId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadMotor(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadMotor(entity);
  }

  /*
   * @param	event AssignLoadMotorToLoadMotorEvent
   */
  @EventHandler(payloadType = AssignLoadMotorToLoadMotorEvent.class)
  public void handle(AssignLoadMotorToLoadMotorEvent event) {
    LOGGER.info("handling AssignLoadMotorToLoadMotorEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadMotor entity = assignLoadMotor(event.getLoadMotorId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadMotor(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadMotor(entity);
  }

  /*
   * @param	event UnAssignLoadMotorFromLoadMotorEvent
   */
  @EventHandler(payloadType = UnAssignLoadMotorFromLoadMotorEvent.class)
  public void handle(UnAssignLoadMotorFromLoadMotorEvent event) {
    LOGGER.info("handling UnAssignLoadMotorFromLoadMotorEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadMotor entity = unAssignLoadMotor(event.getLoadMotorId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadMotor(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadMotor(entity);
  }

  /**
   * Method to retrieve the LoadMotor via an LoadMotorPrimaryKey.
   *
   * @param id Long
   * @return LoadMotor
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public LoadMotor handle(FindLoadMotorQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getLoadMotorId());
  }

  /**
   * Method to retrieve a collection of all LoadMotors
   *
   * @param query FindAllLoadMotorQuery
   * @return List<LoadMotor>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<LoadMotor> handle(FindAllLoadMotorQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindLoadMotor, but only if the id matches
   *
   * @param entity LoadMotor
   */
  protected void emitFindLoadMotor(LoadMotor entity) {
    LOGGER.info("handling emitFindLoadMotor");

    queryUpdateEmitter.emit(
        FindLoadMotorQuery.class,
        query -> query.getFilter().getLoadMotorId().equals(entity.getLoadMotorId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllLoadMotor
   *
   * @param entity LoadMotor
   */
  protected void emitFindAllLoadMotor(LoadMotor entity) {
    LOGGER.info("handling emitFindAllLoadMotor");

    queryUpdateEmitter.emit(FindAllLoadMotorQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(LoadMotorProjector.class.getName());
}
