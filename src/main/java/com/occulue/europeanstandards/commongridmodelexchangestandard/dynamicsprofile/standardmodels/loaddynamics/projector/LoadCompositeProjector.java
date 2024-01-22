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
 * Projector for LoadComposite as outlined for the CQRS pattern. All event handling and query
 * handling related to LoadComposite are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by LoadCompositeAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("loadComposite")
@Component("loadComposite-projector")
public class LoadCompositeProjector extends LoadCompositeEntityProjector {

  // core constructor
  public LoadCompositeProjector(
      LoadCompositeRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateLoadCompositeEvent
   */
  @EventHandler(payloadType = CreateLoadCompositeEvent.class)
  public void handle(CreateLoadCompositeEvent event) {
    LOGGER.info("handling CreateLoadCompositeEvent - " + event);
    LoadComposite entity = new LoadComposite();
    entity.setLoadCompositeId(event.getLoadCompositeId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadComposite(entity);
  }

  /*
   * @param	event UpdateLoadCompositeEvent
   */
  @EventHandler(payloadType = UpdateLoadCompositeEvent.class)
  public void handle(UpdateLoadCompositeEvent event) {
    LOGGER.info("handling UpdateLoadCompositeEvent - " + event);

    LoadComposite entity = new LoadComposite();
    entity.setLoadCompositeId(event.getLoadCompositeId());
    entity.setEpfd(event.getEpfd());
    entity.setEpfs(event.getEpfs());
    entity.setEpvd(event.getEpvd());
    entity.setEpvs(event.getEpvs());
    entity.setEqfd(event.getEqfd());
    entity.setEqfs(event.getEqfs());
    entity.setEqvd(event.getEqvd());
    entity.setEqvs(event.getEqvs());
    entity.setH(event.getH());
    entity.setLfrac(event.getLfrac());
    entity.setPfrac(event.getPfrac());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadComposite(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadComposite(entity);
  }

  /*
   * @param	event DeleteLoadCompositeEvent
   */
  @EventHandler(payloadType = DeleteLoadCompositeEvent.class)
  public void handle(DeleteLoadCompositeEvent event) {
    LOGGER.info("handling DeleteLoadCompositeEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    LoadComposite entity = delete(event.getLoadCompositeId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadComposite(entity);
  }

  /*
   * @param	event AssignEpfdToLoadCompositeEvent
   */
  @EventHandler(payloadType = AssignEpfdToLoadCompositeEvent.class)
  public void handle(AssignEpfdToLoadCompositeEvent event) {
    LOGGER.info("handling AssignEpfdToLoadCompositeEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadComposite entity = assignEpfd(event.getLoadCompositeId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadComposite(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadComposite(entity);
  }

  /*
   * @param	event UnAssignEpfdFromLoadCompositeEvent
   */
  @EventHandler(payloadType = UnAssignEpfdFromLoadCompositeEvent.class)
  public void handle(UnAssignEpfdFromLoadCompositeEvent event) {
    LOGGER.info("handling UnAssignEpfdFromLoadCompositeEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadComposite entity = unAssignEpfd(event.getLoadCompositeId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadComposite(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadComposite(entity);
  }

  /*
   * @param	event AssignEpfsToLoadCompositeEvent
   */
  @EventHandler(payloadType = AssignEpfsToLoadCompositeEvent.class)
  public void handle(AssignEpfsToLoadCompositeEvent event) {
    LOGGER.info("handling AssignEpfsToLoadCompositeEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadComposite entity = assignEpfs(event.getLoadCompositeId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadComposite(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadComposite(entity);
  }

  /*
   * @param	event UnAssignEpfsFromLoadCompositeEvent
   */
  @EventHandler(payloadType = UnAssignEpfsFromLoadCompositeEvent.class)
  public void handle(UnAssignEpfsFromLoadCompositeEvent event) {
    LOGGER.info("handling UnAssignEpfsFromLoadCompositeEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadComposite entity = unAssignEpfs(event.getLoadCompositeId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadComposite(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadComposite(entity);
  }

  /*
   * @param	event AssignEpvdToLoadCompositeEvent
   */
  @EventHandler(payloadType = AssignEpvdToLoadCompositeEvent.class)
  public void handle(AssignEpvdToLoadCompositeEvent event) {
    LOGGER.info("handling AssignEpvdToLoadCompositeEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadComposite entity = assignEpvd(event.getLoadCompositeId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadComposite(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadComposite(entity);
  }

  /*
   * @param	event UnAssignEpvdFromLoadCompositeEvent
   */
  @EventHandler(payloadType = UnAssignEpvdFromLoadCompositeEvent.class)
  public void handle(UnAssignEpvdFromLoadCompositeEvent event) {
    LOGGER.info("handling UnAssignEpvdFromLoadCompositeEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadComposite entity = unAssignEpvd(event.getLoadCompositeId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadComposite(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadComposite(entity);
  }

  /*
   * @param	event AssignEpvsToLoadCompositeEvent
   */
  @EventHandler(payloadType = AssignEpvsToLoadCompositeEvent.class)
  public void handle(AssignEpvsToLoadCompositeEvent event) {
    LOGGER.info("handling AssignEpvsToLoadCompositeEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadComposite entity = assignEpvs(event.getLoadCompositeId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadComposite(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadComposite(entity);
  }

  /*
   * @param	event UnAssignEpvsFromLoadCompositeEvent
   */
  @EventHandler(payloadType = UnAssignEpvsFromLoadCompositeEvent.class)
  public void handle(UnAssignEpvsFromLoadCompositeEvent event) {
    LOGGER.info("handling UnAssignEpvsFromLoadCompositeEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadComposite entity = unAssignEpvs(event.getLoadCompositeId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadComposite(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadComposite(entity);
  }

  /*
   * @param	event AssignEqfdToLoadCompositeEvent
   */
  @EventHandler(payloadType = AssignEqfdToLoadCompositeEvent.class)
  public void handle(AssignEqfdToLoadCompositeEvent event) {
    LOGGER.info("handling AssignEqfdToLoadCompositeEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadComposite entity = assignEqfd(event.getLoadCompositeId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadComposite(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadComposite(entity);
  }

  /*
   * @param	event UnAssignEqfdFromLoadCompositeEvent
   */
  @EventHandler(payloadType = UnAssignEqfdFromLoadCompositeEvent.class)
  public void handle(UnAssignEqfdFromLoadCompositeEvent event) {
    LOGGER.info("handling UnAssignEqfdFromLoadCompositeEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadComposite entity = unAssignEqfd(event.getLoadCompositeId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadComposite(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadComposite(entity);
  }

  /*
   * @param	event AssignEqfsToLoadCompositeEvent
   */
  @EventHandler(payloadType = AssignEqfsToLoadCompositeEvent.class)
  public void handle(AssignEqfsToLoadCompositeEvent event) {
    LOGGER.info("handling AssignEqfsToLoadCompositeEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadComposite entity = assignEqfs(event.getLoadCompositeId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadComposite(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadComposite(entity);
  }

  /*
   * @param	event UnAssignEqfsFromLoadCompositeEvent
   */
  @EventHandler(payloadType = UnAssignEqfsFromLoadCompositeEvent.class)
  public void handle(UnAssignEqfsFromLoadCompositeEvent event) {
    LOGGER.info("handling UnAssignEqfsFromLoadCompositeEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadComposite entity = unAssignEqfs(event.getLoadCompositeId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadComposite(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadComposite(entity);
  }

  /*
   * @param	event AssignEqvdToLoadCompositeEvent
   */
  @EventHandler(payloadType = AssignEqvdToLoadCompositeEvent.class)
  public void handle(AssignEqvdToLoadCompositeEvent event) {
    LOGGER.info("handling AssignEqvdToLoadCompositeEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadComposite entity = assignEqvd(event.getLoadCompositeId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadComposite(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadComposite(entity);
  }

  /*
   * @param	event UnAssignEqvdFromLoadCompositeEvent
   */
  @EventHandler(payloadType = UnAssignEqvdFromLoadCompositeEvent.class)
  public void handle(UnAssignEqvdFromLoadCompositeEvent event) {
    LOGGER.info("handling UnAssignEqvdFromLoadCompositeEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadComposite entity = unAssignEqvd(event.getLoadCompositeId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadComposite(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadComposite(entity);
  }

  /*
   * @param	event AssignEqvsToLoadCompositeEvent
   */
  @EventHandler(payloadType = AssignEqvsToLoadCompositeEvent.class)
  public void handle(AssignEqvsToLoadCompositeEvent event) {
    LOGGER.info("handling AssignEqvsToLoadCompositeEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadComposite entity = assignEqvs(event.getLoadCompositeId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadComposite(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadComposite(entity);
  }

  /*
   * @param	event UnAssignEqvsFromLoadCompositeEvent
   */
  @EventHandler(payloadType = UnAssignEqvsFromLoadCompositeEvent.class)
  public void handle(UnAssignEqvsFromLoadCompositeEvent event) {
    LOGGER.info("handling UnAssignEqvsFromLoadCompositeEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadComposite entity = unAssignEqvs(event.getLoadCompositeId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadComposite(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadComposite(entity);
  }

  /*
   * @param	event AssignHToLoadCompositeEvent
   */
  @EventHandler(payloadType = AssignHToLoadCompositeEvent.class)
  public void handle(AssignHToLoadCompositeEvent event) {
    LOGGER.info("handling AssignHToLoadCompositeEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadComposite entity = assignH(event.getLoadCompositeId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadComposite(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadComposite(entity);
  }

  /*
   * @param	event UnAssignHFromLoadCompositeEvent
   */
  @EventHandler(payloadType = UnAssignHFromLoadCompositeEvent.class)
  public void handle(UnAssignHFromLoadCompositeEvent event) {
    LOGGER.info("handling UnAssignHFromLoadCompositeEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadComposite entity = unAssignH(event.getLoadCompositeId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadComposite(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadComposite(entity);
  }

  /*
   * @param	event AssignLfracToLoadCompositeEvent
   */
  @EventHandler(payloadType = AssignLfracToLoadCompositeEvent.class)
  public void handle(AssignLfracToLoadCompositeEvent event) {
    LOGGER.info("handling AssignLfracToLoadCompositeEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadComposite entity = assignLfrac(event.getLoadCompositeId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadComposite(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadComposite(entity);
  }

  /*
   * @param	event UnAssignLfracFromLoadCompositeEvent
   */
  @EventHandler(payloadType = UnAssignLfracFromLoadCompositeEvent.class)
  public void handle(UnAssignLfracFromLoadCompositeEvent event) {
    LOGGER.info("handling UnAssignLfracFromLoadCompositeEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadComposite entity = unAssignLfrac(event.getLoadCompositeId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadComposite(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadComposite(entity);
  }

  /*
   * @param	event AssignPfracToLoadCompositeEvent
   */
  @EventHandler(payloadType = AssignPfracToLoadCompositeEvent.class)
  public void handle(AssignPfracToLoadCompositeEvent event) {
    LOGGER.info("handling AssignPfracToLoadCompositeEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadComposite entity = assignPfrac(event.getLoadCompositeId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadComposite(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadComposite(entity);
  }

  /*
   * @param	event UnAssignPfracFromLoadCompositeEvent
   */
  @EventHandler(payloadType = UnAssignPfracFromLoadCompositeEvent.class)
  public void handle(UnAssignPfracFromLoadCompositeEvent event) {
    LOGGER.info("handling UnAssignPfracFromLoadCompositeEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadComposite entity = unAssignPfrac(event.getLoadCompositeId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadComposite(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadComposite(entity);
  }

  /**
   * Method to retrieve the LoadComposite via an LoadCompositePrimaryKey.
   *
   * @param id Long
   * @return LoadComposite
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public LoadComposite handle(FindLoadCompositeQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getLoadCompositeId());
  }

  /**
   * Method to retrieve a collection of all LoadComposites
   *
   * @param query FindAllLoadCompositeQuery
   * @return List<LoadComposite>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<LoadComposite> handle(FindAllLoadCompositeQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindLoadComposite, but only if the id matches
   *
   * @param entity LoadComposite
   */
  protected void emitFindLoadComposite(LoadComposite entity) {
    LOGGER.info("handling emitFindLoadComposite");

    queryUpdateEmitter.emit(
        FindLoadCompositeQuery.class,
        query -> query.getFilter().getLoadCompositeId().equals(entity.getLoadCompositeId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllLoadComposite
   *
   * @param entity LoadComposite
   */
  protected void emitFindAllLoadComposite(LoadComposite entity) {
    LOGGER.info("handling emitFindAllLoadComposite");

    queryUpdateEmitter.emit(FindAllLoadCompositeQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(LoadCompositeProjector.class.getName());
}
