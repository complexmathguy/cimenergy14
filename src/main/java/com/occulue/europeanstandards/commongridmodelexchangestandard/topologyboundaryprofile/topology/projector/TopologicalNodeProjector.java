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
package com.occulue.europeanstandards.commongridmodelexchangestandard.topologyboundaryprofile.topology.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.topologyboundaryprofile.topology.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for TopologicalNode as outlined for the CQRS pattern. All event handling and query
 * handling related to TopologicalNode are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by TopologicalNodeAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("topologicalNode")
@Component("topologicalNode-projector")
public class TopologicalNodeProjector extends TopologicalNodeEntityProjector {

  // core constructor
  public TopologicalNodeProjector(
      TopologicalNodeRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateTopologicalNodeEvent
   */
  @EventHandler(payloadType = CreateTopologicalNodeEvent.class)
  public void handle(CreateTopologicalNodeEvent event) {
    LOGGER.info("handling CreateTopologicalNodeEvent - " + event);
    TopologicalNode entity = new TopologicalNode();
    entity.setTopologicalNodeId(event.getTopologicalNodeId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologicalNode(entity);
  }

  /*
   * @param	event UpdateTopologicalNodeEvent
   */
  @EventHandler(payloadType = UpdateTopologicalNodeEvent.class)
  public void handle(UpdateTopologicalNodeEvent event) {
    LOGGER.info("handling UpdateTopologicalNodeEvent - " + event);

    TopologicalNode entity = new TopologicalNode();
    entity.setTopologicalNodeId(event.getTopologicalNodeId());
    entity.setBoundaryPoint(event.getBoundaryPoint());
    entity.setFromEndIsoCode(event.getFromEndIsoCode());
    entity.setFromEndName(event.getFromEndName());
    entity.setFromEndNameTso(event.getFromEndNameTso());
    entity.setToEndIsoCode(event.getToEndIsoCode());
    entity.setToEndName(event.getToEndName());
    entity.setToEndNameTso(event.getToEndNameTso());
    entity.setTopologicalNode(event.getTopologicalNode());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologicalNode(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologicalNode(entity);
  }

  /*
   * @param	event DeleteTopologicalNodeEvent
   */
  @EventHandler(payloadType = DeleteTopologicalNodeEvent.class)
  public void handle(DeleteTopologicalNodeEvent event) {
    LOGGER.info("handling DeleteTopologicalNodeEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    TopologicalNode entity = delete(event.getTopologicalNodeId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologicalNode(entity);
  }

  /*
   * @param	event AssignBoundaryPointToTopologicalNodeEvent
   */
  @EventHandler(payloadType = AssignBoundaryPointToTopologicalNodeEvent.class)
  public void handle(AssignBoundaryPointToTopologicalNodeEvent event) {
    LOGGER.info("handling AssignBoundaryPointToTopologicalNodeEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TopologicalNode entity =
        assignBoundaryPoint(event.getTopologicalNodeId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologicalNode(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologicalNode(entity);
  }

  /*
   * @param	event UnAssignBoundaryPointFromTopologicalNodeEvent
   */
  @EventHandler(payloadType = UnAssignBoundaryPointFromTopologicalNodeEvent.class)
  public void handle(UnAssignBoundaryPointFromTopologicalNodeEvent event) {
    LOGGER.info("handling UnAssignBoundaryPointFromTopologicalNodeEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TopologicalNode entity = unAssignBoundaryPoint(event.getTopologicalNodeId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologicalNode(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologicalNode(entity);
  }

  /*
   * @param	event AssignFromEndIsoCodeToTopologicalNodeEvent
   */
  @EventHandler(payloadType = AssignFromEndIsoCodeToTopologicalNodeEvent.class)
  public void handle(AssignFromEndIsoCodeToTopologicalNodeEvent event) {
    LOGGER.info("handling AssignFromEndIsoCodeToTopologicalNodeEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TopologicalNode entity =
        assignFromEndIsoCode(event.getTopologicalNodeId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologicalNode(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologicalNode(entity);
  }

  /*
   * @param	event UnAssignFromEndIsoCodeFromTopologicalNodeEvent
   */
  @EventHandler(payloadType = UnAssignFromEndIsoCodeFromTopologicalNodeEvent.class)
  public void handle(UnAssignFromEndIsoCodeFromTopologicalNodeEvent event) {
    LOGGER.info("handling UnAssignFromEndIsoCodeFromTopologicalNodeEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TopologicalNode entity = unAssignFromEndIsoCode(event.getTopologicalNodeId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologicalNode(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologicalNode(entity);
  }

  /*
   * @param	event AssignFromEndNameToTopologicalNodeEvent
   */
  @EventHandler(payloadType = AssignFromEndNameToTopologicalNodeEvent.class)
  public void handle(AssignFromEndNameToTopologicalNodeEvent event) {
    LOGGER.info("handling AssignFromEndNameToTopologicalNodeEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TopologicalNode entity = assignFromEndName(event.getTopologicalNodeId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologicalNode(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologicalNode(entity);
  }

  /*
   * @param	event UnAssignFromEndNameFromTopologicalNodeEvent
   */
  @EventHandler(payloadType = UnAssignFromEndNameFromTopologicalNodeEvent.class)
  public void handle(UnAssignFromEndNameFromTopologicalNodeEvent event) {
    LOGGER.info("handling UnAssignFromEndNameFromTopologicalNodeEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TopologicalNode entity = unAssignFromEndName(event.getTopologicalNodeId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologicalNode(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologicalNode(entity);
  }

  /*
   * @param	event AssignFromEndNameTsoToTopologicalNodeEvent
   */
  @EventHandler(payloadType = AssignFromEndNameTsoToTopologicalNodeEvent.class)
  public void handle(AssignFromEndNameTsoToTopologicalNodeEvent event) {
    LOGGER.info("handling AssignFromEndNameTsoToTopologicalNodeEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TopologicalNode entity =
        assignFromEndNameTso(event.getTopologicalNodeId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologicalNode(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologicalNode(entity);
  }

  /*
   * @param	event UnAssignFromEndNameTsoFromTopologicalNodeEvent
   */
  @EventHandler(payloadType = UnAssignFromEndNameTsoFromTopologicalNodeEvent.class)
  public void handle(UnAssignFromEndNameTsoFromTopologicalNodeEvent event) {
    LOGGER.info("handling UnAssignFromEndNameTsoFromTopologicalNodeEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TopologicalNode entity = unAssignFromEndNameTso(event.getTopologicalNodeId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologicalNode(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologicalNode(entity);
  }

  /*
   * @param	event AssignToEndIsoCodeToTopologicalNodeEvent
   */
  @EventHandler(payloadType = AssignToEndIsoCodeToTopologicalNodeEvent.class)
  public void handle(AssignToEndIsoCodeToTopologicalNodeEvent event) {
    LOGGER.info("handling AssignToEndIsoCodeToTopologicalNodeEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TopologicalNode entity =
        assignToEndIsoCode(event.getTopologicalNodeId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologicalNode(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologicalNode(entity);
  }

  /*
   * @param	event UnAssignToEndIsoCodeFromTopologicalNodeEvent
   */
  @EventHandler(payloadType = UnAssignToEndIsoCodeFromTopologicalNodeEvent.class)
  public void handle(UnAssignToEndIsoCodeFromTopologicalNodeEvent event) {
    LOGGER.info("handling UnAssignToEndIsoCodeFromTopologicalNodeEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TopologicalNode entity = unAssignToEndIsoCode(event.getTopologicalNodeId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologicalNode(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologicalNode(entity);
  }

  /*
   * @param	event AssignToEndNameToTopologicalNodeEvent
   */
  @EventHandler(payloadType = AssignToEndNameToTopologicalNodeEvent.class)
  public void handle(AssignToEndNameToTopologicalNodeEvent event) {
    LOGGER.info("handling AssignToEndNameToTopologicalNodeEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TopologicalNode entity = assignToEndName(event.getTopologicalNodeId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologicalNode(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologicalNode(entity);
  }

  /*
   * @param	event UnAssignToEndNameFromTopologicalNodeEvent
   */
  @EventHandler(payloadType = UnAssignToEndNameFromTopologicalNodeEvent.class)
  public void handle(UnAssignToEndNameFromTopologicalNodeEvent event) {
    LOGGER.info("handling UnAssignToEndNameFromTopologicalNodeEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TopologicalNode entity = unAssignToEndName(event.getTopologicalNodeId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologicalNode(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologicalNode(entity);
  }

  /*
   * @param	event AssignToEndNameTsoToTopologicalNodeEvent
   */
  @EventHandler(payloadType = AssignToEndNameTsoToTopologicalNodeEvent.class)
  public void handle(AssignToEndNameTsoToTopologicalNodeEvent event) {
    LOGGER.info("handling AssignToEndNameTsoToTopologicalNodeEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TopologicalNode entity =
        assignToEndNameTso(event.getTopologicalNodeId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologicalNode(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologicalNode(entity);
  }

  /*
   * @param	event UnAssignToEndNameTsoFromTopologicalNodeEvent
   */
  @EventHandler(payloadType = UnAssignToEndNameTsoFromTopologicalNodeEvent.class)
  public void handle(UnAssignToEndNameTsoFromTopologicalNodeEvent event) {
    LOGGER.info("handling UnAssignToEndNameTsoFromTopologicalNodeEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TopologicalNode entity = unAssignToEndNameTso(event.getTopologicalNodeId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologicalNode(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologicalNode(entity);
  }

  /*
   * @param	event AssignTopologicalNodeToTopologicalNodeEvent
   */
  @EventHandler(payloadType = AssignTopologicalNodeToTopologicalNodeEvent.class)
  public void handle(AssignTopologicalNodeToTopologicalNodeEvent event) {
    LOGGER.info("handling AssignTopologicalNodeToTopologicalNodeEvent - " + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    TopologicalNode entity = addToTopologicalNode(event.getTopologicalNodeId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologicalNode(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologicalNode(entity);
  }

  /*
   * @param	event RemoveTopologicalNodeFromTopologicalNodeEvent
   */
  @EventHandler(payloadType = RemoveTopologicalNodeFromTopologicalNodeEvent.class)
  public void handle(RemoveTopologicalNodeFromTopologicalNodeEvent event) {
    LOGGER.info("handling RemoveTopologicalNodeFromTopologicalNodeEvent - " + event);

    TopologicalNode entity =
        removeFromTopologicalNode(event.getTopologicalNodeId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologicalNode(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologicalNode(entity);
  }

  /**
   * Method to retrieve the TopologicalNode via an TopologicalNodePrimaryKey.
   *
   * @param id Long
   * @return TopologicalNode
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public TopologicalNode handle(FindTopologicalNodeQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getTopologicalNodeId());
  }

  /**
   * Method to retrieve a collection of all TopologicalNodes
   *
   * @param query FindAllTopologicalNodeQuery
   * @return List<TopologicalNode>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<TopologicalNode> handle(FindAllTopologicalNodeQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindTopologicalNode, but only if the id matches
   *
   * @param entity TopologicalNode
   */
  protected void emitFindTopologicalNode(TopologicalNode entity) {
    LOGGER.info("handling emitFindTopologicalNode");

    queryUpdateEmitter.emit(
        FindTopologicalNodeQuery.class,
        query -> query.getFilter().getTopologicalNodeId().equals(entity.getTopologicalNodeId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllTopologicalNode
   *
   * @param entity TopologicalNode
   */
  protected void emitFindAllTopologicalNode(TopologicalNode entity) {
    LOGGER.info("handling emitFindAllTopologicalNode");

    queryUpdateEmitter.emit(FindAllTopologicalNodeQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(TopologicalNodeProjector.class.getName());
}
