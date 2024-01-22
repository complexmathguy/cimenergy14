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
package com.occulue.europeanstandards.extension.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.extension.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for BoundaryExtensions as outlined for the CQRS pattern. All event handling and query
 * handling related to BoundaryExtensions are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by BoundaryExtensionsAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("boundaryExtensions")
@Component("boundaryExtensions-projector")
public class BoundaryExtensionsProjector extends BoundaryExtensionsEntityProjector {

  // core constructor
  public BoundaryExtensionsProjector(
      BoundaryExtensionsRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateBoundaryExtensionsEvent
   */
  @EventHandler(payloadType = CreateBoundaryExtensionsEvent.class)
  public void handle(CreateBoundaryExtensionsEvent event) {
    LOGGER.info("handling CreateBoundaryExtensionsEvent - " + event);
    BoundaryExtensions entity = new BoundaryExtensions();
    entity.setBoundaryExtensionsId(event.getBoundaryExtensionsId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllBoundaryExtensions(entity);
  }

  /*
   * @param	event UpdateBoundaryExtensionsEvent
   */
  @EventHandler(payloadType = UpdateBoundaryExtensionsEvent.class)
  public void handle(UpdateBoundaryExtensionsEvent event) {
    LOGGER.info("handling UpdateBoundaryExtensionsEvent - " + event);

    BoundaryExtensions entity = new BoundaryExtensions();
    entity.setBoundaryExtensionsId(event.getBoundaryExtensionsId());
    entity.setBoundaryPoint(event.getBoundaryPoint());
    entity.setFromEndIsoCode(event.getFromEndIsoCode());
    entity.setFromEndName(event.getFromEndName());
    entity.setFromEndNameTso(event.getFromEndNameTso());
    entity.setToEndIsoCode(event.getToEndIsoCode());
    entity.setToEndName(event.getToEndName());
    entity.setToEndNameTso(event.getToEndNameTso());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindBoundaryExtensions(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllBoundaryExtensions(entity);
  }

  /*
   * @param	event DeleteBoundaryExtensionsEvent
   */
  @EventHandler(payloadType = DeleteBoundaryExtensionsEvent.class)
  public void handle(DeleteBoundaryExtensionsEvent event) {
    LOGGER.info("handling DeleteBoundaryExtensionsEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    BoundaryExtensions entity = delete(event.getBoundaryExtensionsId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllBoundaryExtensions(entity);
  }

  /*
   * @param	event AssignBoundaryPointToBoundaryExtensionsEvent
   */
  @EventHandler(payloadType = AssignBoundaryPointToBoundaryExtensionsEvent.class)
  public void handle(AssignBoundaryPointToBoundaryExtensionsEvent event) {
    LOGGER.info("handling AssignBoundaryPointToBoundaryExtensionsEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    BoundaryExtensions entity =
        assignBoundaryPoint(event.getBoundaryExtensionsId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindBoundaryExtensions(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllBoundaryExtensions(entity);
  }

  /*
   * @param	event UnAssignBoundaryPointFromBoundaryExtensionsEvent
   */
  @EventHandler(payloadType = UnAssignBoundaryPointFromBoundaryExtensionsEvent.class)
  public void handle(UnAssignBoundaryPointFromBoundaryExtensionsEvent event) {
    LOGGER.info("handling UnAssignBoundaryPointFromBoundaryExtensionsEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    BoundaryExtensions entity = unAssignBoundaryPoint(event.getBoundaryExtensionsId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindBoundaryExtensions(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllBoundaryExtensions(entity);
  }

  /*
   * @param	event AssignFromEndIsoCodeToBoundaryExtensionsEvent
   */
  @EventHandler(payloadType = AssignFromEndIsoCodeToBoundaryExtensionsEvent.class)
  public void handle(AssignFromEndIsoCodeToBoundaryExtensionsEvent event) {
    LOGGER.info("handling AssignFromEndIsoCodeToBoundaryExtensionsEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    BoundaryExtensions entity =
        assignFromEndIsoCode(event.getBoundaryExtensionsId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindBoundaryExtensions(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllBoundaryExtensions(entity);
  }

  /*
   * @param	event UnAssignFromEndIsoCodeFromBoundaryExtensionsEvent
   */
  @EventHandler(payloadType = UnAssignFromEndIsoCodeFromBoundaryExtensionsEvent.class)
  public void handle(UnAssignFromEndIsoCodeFromBoundaryExtensionsEvent event) {
    LOGGER.info("handling UnAssignFromEndIsoCodeFromBoundaryExtensionsEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    BoundaryExtensions entity = unAssignFromEndIsoCode(event.getBoundaryExtensionsId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindBoundaryExtensions(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllBoundaryExtensions(entity);
  }

  /*
   * @param	event AssignFromEndNameToBoundaryExtensionsEvent
   */
  @EventHandler(payloadType = AssignFromEndNameToBoundaryExtensionsEvent.class)
  public void handle(AssignFromEndNameToBoundaryExtensionsEvent event) {
    LOGGER.info("handling AssignFromEndNameToBoundaryExtensionsEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    BoundaryExtensions entity =
        assignFromEndName(event.getBoundaryExtensionsId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindBoundaryExtensions(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllBoundaryExtensions(entity);
  }

  /*
   * @param	event UnAssignFromEndNameFromBoundaryExtensionsEvent
   */
  @EventHandler(payloadType = UnAssignFromEndNameFromBoundaryExtensionsEvent.class)
  public void handle(UnAssignFromEndNameFromBoundaryExtensionsEvent event) {
    LOGGER.info("handling UnAssignFromEndNameFromBoundaryExtensionsEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    BoundaryExtensions entity = unAssignFromEndName(event.getBoundaryExtensionsId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindBoundaryExtensions(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllBoundaryExtensions(entity);
  }

  /*
   * @param	event AssignFromEndNameTsoToBoundaryExtensionsEvent
   */
  @EventHandler(payloadType = AssignFromEndNameTsoToBoundaryExtensionsEvent.class)
  public void handle(AssignFromEndNameTsoToBoundaryExtensionsEvent event) {
    LOGGER.info("handling AssignFromEndNameTsoToBoundaryExtensionsEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    BoundaryExtensions entity =
        assignFromEndNameTso(event.getBoundaryExtensionsId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindBoundaryExtensions(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllBoundaryExtensions(entity);
  }

  /*
   * @param	event UnAssignFromEndNameTsoFromBoundaryExtensionsEvent
   */
  @EventHandler(payloadType = UnAssignFromEndNameTsoFromBoundaryExtensionsEvent.class)
  public void handle(UnAssignFromEndNameTsoFromBoundaryExtensionsEvent event) {
    LOGGER.info("handling UnAssignFromEndNameTsoFromBoundaryExtensionsEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    BoundaryExtensions entity = unAssignFromEndNameTso(event.getBoundaryExtensionsId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindBoundaryExtensions(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllBoundaryExtensions(entity);
  }

  /*
   * @param	event AssignToEndIsoCodeToBoundaryExtensionsEvent
   */
  @EventHandler(payloadType = AssignToEndIsoCodeToBoundaryExtensionsEvent.class)
  public void handle(AssignToEndIsoCodeToBoundaryExtensionsEvent event) {
    LOGGER.info("handling AssignToEndIsoCodeToBoundaryExtensionsEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    BoundaryExtensions entity =
        assignToEndIsoCode(event.getBoundaryExtensionsId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindBoundaryExtensions(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllBoundaryExtensions(entity);
  }

  /*
   * @param	event UnAssignToEndIsoCodeFromBoundaryExtensionsEvent
   */
  @EventHandler(payloadType = UnAssignToEndIsoCodeFromBoundaryExtensionsEvent.class)
  public void handle(UnAssignToEndIsoCodeFromBoundaryExtensionsEvent event) {
    LOGGER.info("handling UnAssignToEndIsoCodeFromBoundaryExtensionsEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    BoundaryExtensions entity = unAssignToEndIsoCode(event.getBoundaryExtensionsId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindBoundaryExtensions(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllBoundaryExtensions(entity);
  }

  /*
   * @param	event AssignToEndNameToBoundaryExtensionsEvent
   */
  @EventHandler(payloadType = AssignToEndNameToBoundaryExtensionsEvent.class)
  public void handle(AssignToEndNameToBoundaryExtensionsEvent event) {
    LOGGER.info("handling AssignToEndNameToBoundaryExtensionsEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    BoundaryExtensions entity =
        assignToEndName(event.getBoundaryExtensionsId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindBoundaryExtensions(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllBoundaryExtensions(entity);
  }

  /*
   * @param	event UnAssignToEndNameFromBoundaryExtensionsEvent
   */
  @EventHandler(payloadType = UnAssignToEndNameFromBoundaryExtensionsEvent.class)
  public void handle(UnAssignToEndNameFromBoundaryExtensionsEvent event) {
    LOGGER.info("handling UnAssignToEndNameFromBoundaryExtensionsEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    BoundaryExtensions entity = unAssignToEndName(event.getBoundaryExtensionsId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindBoundaryExtensions(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllBoundaryExtensions(entity);
  }

  /*
   * @param	event AssignToEndNameTsoToBoundaryExtensionsEvent
   */
  @EventHandler(payloadType = AssignToEndNameTsoToBoundaryExtensionsEvent.class)
  public void handle(AssignToEndNameTsoToBoundaryExtensionsEvent event) {
    LOGGER.info("handling AssignToEndNameTsoToBoundaryExtensionsEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    BoundaryExtensions entity =
        assignToEndNameTso(event.getBoundaryExtensionsId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindBoundaryExtensions(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllBoundaryExtensions(entity);
  }

  /*
   * @param	event UnAssignToEndNameTsoFromBoundaryExtensionsEvent
   */
  @EventHandler(payloadType = UnAssignToEndNameTsoFromBoundaryExtensionsEvent.class)
  public void handle(UnAssignToEndNameTsoFromBoundaryExtensionsEvent event) {
    LOGGER.info("handling UnAssignToEndNameTsoFromBoundaryExtensionsEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    BoundaryExtensions entity = unAssignToEndNameTso(event.getBoundaryExtensionsId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindBoundaryExtensions(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllBoundaryExtensions(entity);
  }

  /**
   * Method to retrieve the BoundaryExtensions via an BoundaryExtensionsPrimaryKey.
   *
   * @param id Long
   * @return BoundaryExtensions
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public BoundaryExtensions handle(FindBoundaryExtensionsQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getBoundaryExtensionsId());
  }

  /**
   * Method to retrieve a collection of all BoundaryExtensionss
   *
   * @param query FindAllBoundaryExtensionsQuery
   * @return List<BoundaryExtensions>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<BoundaryExtensions> handle(FindAllBoundaryExtensionsQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindBoundaryExtensions, but only if the id matches
   *
   * @param entity BoundaryExtensions
   */
  protected void emitFindBoundaryExtensions(BoundaryExtensions entity) {
    LOGGER.info("handling emitFindBoundaryExtensions");

    queryUpdateEmitter.emit(
        FindBoundaryExtensionsQuery.class,
        query ->
            query.getFilter().getBoundaryExtensionsId().equals(entity.getBoundaryExtensionsId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllBoundaryExtensions
   *
   * @param entity BoundaryExtensions
   */
  protected void emitFindAllBoundaryExtensions(BoundaryExtensions entity) {
    LOGGER.info("handling emitFindAllBoundaryExtensions");

    queryUpdateEmitter.emit(FindAllBoundaryExtensionsQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(BoundaryExtensionsProjector.class.getName());
}
