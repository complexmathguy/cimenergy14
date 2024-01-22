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
 * Projector for LoadGenericNonLinear as outlined for the CQRS pattern. All event handling and query
 * handling related to LoadGenericNonLinear are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by LoadGenericNonLinearAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("loadGenericNonLinear")
@Component("loadGenericNonLinear-projector")
public class LoadGenericNonLinearProjector extends LoadGenericNonLinearEntityProjector {

  // core constructor
  public LoadGenericNonLinearProjector(
      LoadGenericNonLinearRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateLoadGenericNonLinearEvent
   */
  @EventHandler(payloadType = CreateLoadGenericNonLinearEvent.class)
  public void handle(CreateLoadGenericNonLinearEvent event) {
    LOGGER.info("handling CreateLoadGenericNonLinearEvent - " + event);
    LoadGenericNonLinear entity = new LoadGenericNonLinear();
    entity.setLoadGenericNonLinearId(event.getLoadGenericNonLinearId());
    entity.setGenericNonLinearLoadModelType(event.getGenericNonLinearLoadModelType());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadGenericNonLinear(entity);
  }

  /*
   * @param	event UpdateLoadGenericNonLinearEvent
   */
  @EventHandler(payloadType = UpdateLoadGenericNonLinearEvent.class)
  public void handle(UpdateLoadGenericNonLinearEvent event) {
    LOGGER.info("handling UpdateLoadGenericNonLinearEvent - " + event);

    LoadGenericNonLinear entity = new LoadGenericNonLinear();
    entity.setLoadGenericNonLinearId(event.getLoadGenericNonLinearId());
    entity.setBs(event.getBs());
    entity.setBt(event.getBt());
    entity.setGenericNonLinearLoadModelType(event.getGenericNonLinearLoadModelType());
    entity.setLs(event.getLs());
    entity.setLt(event.getLt());
    entity.setPt(event.getPt());
    entity.setQt(event.getQt());
    entity.setTp(event.getTp());
    entity.setTq(event.getTq());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadGenericNonLinear(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadGenericNonLinear(entity);
  }

  /*
   * @param	event DeleteLoadGenericNonLinearEvent
   */
  @EventHandler(payloadType = DeleteLoadGenericNonLinearEvent.class)
  public void handle(DeleteLoadGenericNonLinearEvent event) {
    LOGGER.info("handling DeleteLoadGenericNonLinearEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    LoadGenericNonLinear entity = delete(event.getLoadGenericNonLinearId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadGenericNonLinear(entity);
  }

  /*
   * @param	event AssignBsToLoadGenericNonLinearEvent
   */
  @EventHandler(payloadType = AssignBsToLoadGenericNonLinearEvent.class)
  public void handle(AssignBsToLoadGenericNonLinearEvent event) {
    LOGGER.info("handling AssignBsToLoadGenericNonLinearEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadGenericNonLinear entity =
        assignBs(event.getLoadGenericNonLinearId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadGenericNonLinear(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadGenericNonLinear(entity);
  }

  /*
   * @param	event UnAssignBsFromLoadGenericNonLinearEvent
   */
  @EventHandler(payloadType = UnAssignBsFromLoadGenericNonLinearEvent.class)
  public void handle(UnAssignBsFromLoadGenericNonLinearEvent event) {
    LOGGER.info("handling UnAssignBsFromLoadGenericNonLinearEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadGenericNonLinear entity = unAssignBs(event.getLoadGenericNonLinearId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadGenericNonLinear(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadGenericNonLinear(entity);
  }

  /*
   * @param	event AssignBtToLoadGenericNonLinearEvent
   */
  @EventHandler(payloadType = AssignBtToLoadGenericNonLinearEvent.class)
  public void handle(AssignBtToLoadGenericNonLinearEvent event) {
    LOGGER.info("handling AssignBtToLoadGenericNonLinearEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadGenericNonLinear entity =
        assignBt(event.getLoadGenericNonLinearId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadGenericNonLinear(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadGenericNonLinear(entity);
  }

  /*
   * @param	event UnAssignBtFromLoadGenericNonLinearEvent
   */
  @EventHandler(payloadType = UnAssignBtFromLoadGenericNonLinearEvent.class)
  public void handle(UnAssignBtFromLoadGenericNonLinearEvent event) {
    LOGGER.info("handling UnAssignBtFromLoadGenericNonLinearEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadGenericNonLinear entity = unAssignBt(event.getLoadGenericNonLinearId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadGenericNonLinear(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadGenericNonLinear(entity);
  }

  /*
   * @param	event AssignLsToLoadGenericNonLinearEvent
   */
  @EventHandler(payloadType = AssignLsToLoadGenericNonLinearEvent.class)
  public void handle(AssignLsToLoadGenericNonLinearEvent event) {
    LOGGER.info("handling AssignLsToLoadGenericNonLinearEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadGenericNonLinear entity =
        assignLs(event.getLoadGenericNonLinearId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadGenericNonLinear(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadGenericNonLinear(entity);
  }

  /*
   * @param	event UnAssignLsFromLoadGenericNonLinearEvent
   */
  @EventHandler(payloadType = UnAssignLsFromLoadGenericNonLinearEvent.class)
  public void handle(UnAssignLsFromLoadGenericNonLinearEvent event) {
    LOGGER.info("handling UnAssignLsFromLoadGenericNonLinearEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadGenericNonLinear entity = unAssignLs(event.getLoadGenericNonLinearId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadGenericNonLinear(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadGenericNonLinear(entity);
  }

  /*
   * @param	event AssignLtToLoadGenericNonLinearEvent
   */
  @EventHandler(payloadType = AssignLtToLoadGenericNonLinearEvent.class)
  public void handle(AssignLtToLoadGenericNonLinearEvent event) {
    LOGGER.info("handling AssignLtToLoadGenericNonLinearEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadGenericNonLinear entity =
        assignLt(event.getLoadGenericNonLinearId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadGenericNonLinear(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadGenericNonLinear(entity);
  }

  /*
   * @param	event UnAssignLtFromLoadGenericNonLinearEvent
   */
  @EventHandler(payloadType = UnAssignLtFromLoadGenericNonLinearEvent.class)
  public void handle(UnAssignLtFromLoadGenericNonLinearEvent event) {
    LOGGER.info("handling UnAssignLtFromLoadGenericNonLinearEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadGenericNonLinear entity = unAssignLt(event.getLoadGenericNonLinearId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadGenericNonLinear(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadGenericNonLinear(entity);
  }

  /*
   * @param	event AssignPtToLoadGenericNonLinearEvent
   */
  @EventHandler(payloadType = AssignPtToLoadGenericNonLinearEvent.class)
  public void handle(AssignPtToLoadGenericNonLinearEvent event) {
    LOGGER.info("handling AssignPtToLoadGenericNonLinearEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadGenericNonLinear entity =
        assignPt(event.getLoadGenericNonLinearId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadGenericNonLinear(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadGenericNonLinear(entity);
  }

  /*
   * @param	event UnAssignPtFromLoadGenericNonLinearEvent
   */
  @EventHandler(payloadType = UnAssignPtFromLoadGenericNonLinearEvent.class)
  public void handle(UnAssignPtFromLoadGenericNonLinearEvent event) {
    LOGGER.info("handling UnAssignPtFromLoadGenericNonLinearEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadGenericNonLinear entity = unAssignPt(event.getLoadGenericNonLinearId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadGenericNonLinear(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadGenericNonLinear(entity);
  }

  /*
   * @param	event AssignQtToLoadGenericNonLinearEvent
   */
  @EventHandler(payloadType = AssignQtToLoadGenericNonLinearEvent.class)
  public void handle(AssignQtToLoadGenericNonLinearEvent event) {
    LOGGER.info("handling AssignQtToLoadGenericNonLinearEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadGenericNonLinear entity =
        assignQt(event.getLoadGenericNonLinearId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadGenericNonLinear(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadGenericNonLinear(entity);
  }

  /*
   * @param	event UnAssignQtFromLoadGenericNonLinearEvent
   */
  @EventHandler(payloadType = UnAssignQtFromLoadGenericNonLinearEvent.class)
  public void handle(UnAssignQtFromLoadGenericNonLinearEvent event) {
    LOGGER.info("handling UnAssignQtFromLoadGenericNonLinearEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadGenericNonLinear entity = unAssignQt(event.getLoadGenericNonLinearId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadGenericNonLinear(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadGenericNonLinear(entity);
  }

  /*
   * @param	event AssignTpToLoadGenericNonLinearEvent
   */
  @EventHandler(payloadType = AssignTpToLoadGenericNonLinearEvent.class)
  public void handle(AssignTpToLoadGenericNonLinearEvent event) {
    LOGGER.info("handling AssignTpToLoadGenericNonLinearEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadGenericNonLinear entity =
        assignTp(event.getLoadGenericNonLinearId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadGenericNonLinear(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadGenericNonLinear(entity);
  }

  /*
   * @param	event UnAssignTpFromLoadGenericNonLinearEvent
   */
  @EventHandler(payloadType = UnAssignTpFromLoadGenericNonLinearEvent.class)
  public void handle(UnAssignTpFromLoadGenericNonLinearEvent event) {
    LOGGER.info("handling UnAssignTpFromLoadGenericNonLinearEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadGenericNonLinear entity = unAssignTp(event.getLoadGenericNonLinearId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadGenericNonLinear(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadGenericNonLinear(entity);
  }

  /*
   * @param	event AssignTqToLoadGenericNonLinearEvent
   */
  @EventHandler(payloadType = AssignTqToLoadGenericNonLinearEvent.class)
  public void handle(AssignTqToLoadGenericNonLinearEvent event) {
    LOGGER.info("handling AssignTqToLoadGenericNonLinearEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadGenericNonLinear entity =
        assignTq(event.getLoadGenericNonLinearId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadGenericNonLinear(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadGenericNonLinear(entity);
  }

  /*
   * @param	event UnAssignTqFromLoadGenericNonLinearEvent
   */
  @EventHandler(payloadType = UnAssignTqFromLoadGenericNonLinearEvent.class)
  public void handle(UnAssignTqFromLoadGenericNonLinearEvent event) {
    LOGGER.info("handling UnAssignTqFromLoadGenericNonLinearEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadGenericNonLinear entity = unAssignTq(event.getLoadGenericNonLinearId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadGenericNonLinear(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadGenericNonLinear(entity);
  }

  /**
   * Method to retrieve the LoadGenericNonLinear via an LoadGenericNonLinearPrimaryKey.
   *
   * @param id Long
   * @return LoadGenericNonLinear
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public LoadGenericNonLinear handle(FindLoadGenericNonLinearQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getLoadGenericNonLinearId());
  }

  /**
   * Method to retrieve a collection of all LoadGenericNonLinears
   *
   * @param query FindAllLoadGenericNonLinearQuery
   * @return List<LoadGenericNonLinear>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<LoadGenericNonLinear> handle(FindAllLoadGenericNonLinearQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindLoadGenericNonLinear, but only if the id matches
   *
   * @param entity LoadGenericNonLinear
   */
  protected void emitFindLoadGenericNonLinear(LoadGenericNonLinear entity) {
    LOGGER.info("handling emitFindLoadGenericNonLinear");

    queryUpdateEmitter.emit(
        FindLoadGenericNonLinearQuery.class,
        query ->
            query
                .getFilter()
                .getLoadGenericNonLinearId()
                .equals(entity.getLoadGenericNonLinearId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllLoadGenericNonLinear
   *
   * @param entity LoadGenericNonLinear
   */
  protected void emitFindAllLoadGenericNonLinear(LoadGenericNonLinear entity) {
    LOGGER.info("handling emitFindAllLoadGenericNonLinear");

    queryUpdateEmitter.emit(FindAllLoadGenericNonLinearQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(LoadGenericNonLinearProjector.class.getName());
}
