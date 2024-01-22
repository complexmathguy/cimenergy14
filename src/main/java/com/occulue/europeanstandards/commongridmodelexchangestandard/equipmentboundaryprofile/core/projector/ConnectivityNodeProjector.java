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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for ConnectivityNode as outlined for the CQRS pattern. All event handling and query
 * handling related to ConnectivityNode are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by ConnectivityNodeAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("connectivityNode")
@Component("connectivityNode-projector")
public class ConnectivityNodeProjector extends ConnectivityNodeEntityProjector {

  // core constructor
  public ConnectivityNodeProjector(
      ConnectivityNodeRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateConnectivityNodeEvent
   */
  @EventHandler(payloadType = CreateConnectivityNodeEvent.class)
  public void handle(CreateConnectivityNodeEvent event) {
    LOGGER.info("handling CreateConnectivityNodeEvent - " + event);
    ConnectivityNode entity = new ConnectivityNode();
    entity.setConnectivityNodeId(event.getConnectivityNodeId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllConnectivityNode(entity);
  }

  /*
   * @param	event UpdateConnectivityNodeEvent
   */
  @EventHandler(payloadType = UpdateConnectivityNodeEvent.class)
  public void handle(UpdateConnectivityNodeEvent event) {
    LOGGER.info("handling UpdateConnectivityNodeEvent - " + event);

    ConnectivityNode entity = new ConnectivityNode();
    entity.setConnectivityNodeId(event.getConnectivityNodeId());
    entity.setBoundaryPoint(event.getBoundaryPoint());
    entity.setFromEndIsoCode(event.getFromEndIsoCode());
    entity.setFromEndName(event.getFromEndName());
    entity.setFromEndNameTso(event.getFromEndNameTso());
    entity.setToEndIsoCode(event.getToEndIsoCode());
    entity.setToEndName(event.getToEndName());
    entity.setToEndNameTso(event.getToEndNameTso());
    entity.setConnectivityNodes(event.getConnectivityNodes());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindConnectivityNode(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllConnectivityNode(entity);
  }

  /*
   * @param	event DeleteConnectivityNodeEvent
   */
  @EventHandler(payloadType = DeleteConnectivityNodeEvent.class)
  public void handle(DeleteConnectivityNodeEvent event) {
    LOGGER.info("handling DeleteConnectivityNodeEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ConnectivityNode entity = delete(event.getConnectivityNodeId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllConnectivityNode(entity);
  }

  /*
   * @param	event AssignBoundaryPointToConnectivityNodeEvent
   */
  @EventHandler(payloadType = AssignBoundaryPointToConnectivityNodeEvent.class)
  public void handle(AssignBoundaryPointToConnectivityNodeEvent event) {
    LOGGER.info("handling AssignBoundaryPointToConnectivityNodeEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ConnectivityNode entity =
        assignBoundaryPoint(event.getConnectivityNodeId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindConnectivityNode(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllConnectivityNode(entity);
  }

  /*
   * @param	event UnAssignBoundaryPointFromConnectivityNodeEvent
   */
  @EventHandler(payloadType = UnAssignBoundaryPointFromConnectivityNodeEvent.class)
  public void handle(UnAssignBoundaryPointFromConnectivityNodeEvent event) {
    LOGGER.info("handling UnAssignBoundaryPointFromConnectivityNodeEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ConnectivityNode entity = unAssignBoundaryPoint(event.getConnectivityNodeId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindConnectivityNode(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllConnectivityNode(entity);
  }

  /*
   * @param	event AssignFromEndIsoCodeToConnectivityNodeEvent
   */
  @EventHandler(payloadType = AssignFromEndIsoCodeToConnectivityNodeEvent.class)
  public void handle(AssignFromEndIsoCodeToConnectivityNodeEvent event) {
    LOGGER.info("handling AssignFromEndIsoCodeToConnectivityNodeEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ConnectivityNode entity =
        assignFromEndIsoCode(event.getConnectivityNodeId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindConnectivityNode(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllConnectivityNode(entity);
  }

  /*
   * @param	event UnAssignFromEndIsoCodeFromConnectivityNodeEvent
   */
  @EventHandler(payloadType = UnAssignFromEndIsoCodeFromConnectivityNodeEvent.class)
  public void handle(UnAssignFromEndIsoCodeFromConnectivityNodeEvent event) {
    LOGGER.info("handling UnAssignFromEndIsoCodeFromConnectivityNodeEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ConnectivityNode entity = unAssignFromEndIsoCode(event.getConnectivityNodeId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindConnectivityNode(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllConnectivityNode(entity);
  }

  /*
   * @param	event AssignFromEndNameToConnectivityNodeEvent
   */
  @EventHandler(payloadType = AssignFromEndNameToConnectivityNodeEvent.class)
  public void handle(AssignFromEndNameToConnectivityNodeEvent event) {
    LOGGER.info("handling AssignFromEndNameToConnectivityNodeEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ConnectivityNode entity =
        assignFromEndName(event.getConnectivityNodeId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindConnectivityNode(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllConnectivityNode(entity);
  }

  /*
   * @param	event UnAssignFromEndNameFromConnectivityNodeEvent
   */
  @EventHandler(payloadType = UnAssignFromEndNameFromConnectivityNodeEvent.class)
  public void handle(UnAssignFromEndNameFromConnectivityNodeEvent event) {
    LOGGER.info("handling UnAssignFromEndNameFromConnectivityNodeEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ConnectivityNode entity = unAssignFromEndName(event.getConnectivityNodeId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindConnectivityNode(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllConnectivityNode(entity);
  }

  /*
   * @param	event AssignFromEndNameTsoToConnectivityNodeEvent
   */
  @EventHandler(payloadType = AssignFromEndNameTsoToConnectivityNodeEvent.class)
  public void handle(AssignFromEndNameTsoToConnectivityNodeEvent event) {
    LOGGER.info("handling AssignFromEndNameTsoToConnectivityNodeEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ConnectivityNode entity =
        assignFromEndNameTso(event.getConnectivityNodeId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindConnectivityNode(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllConnectivityNode(entity);
  }

  /*
   * @param	event UnAssignFromEndNameTsoFromConnectivityNodeEvent
   */
  @EventHandler(payloadType = UnAssignFromEndNameTsoFromConnectivityNodeEvent.class)
  public void handle(UnAssignFromEndNameTsoFromConnectivityNodeEvent event) {
    LOGGER.info("handling UnAssignFromEndNameTsoFromConnectivityNodeEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ConnectivityNode entity = unAssignFromEndNameTso(event.getConnectivityNodeId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindConnectivityNode(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllConnectivityNode(entity);
  }

  /*
   * @param	event AssignToEndIsoCodeToConnectivityNodeEvent
   */
  @EventHandler(payloadType = AssignToEndIsoCodeToConnectivityNodeEvent.class)
  public void handle(AssignToEndIsoCodeToConnectivityNodeEvent event) {
    LOGGER.info("handling AssignToEndIsoCodeToConnectivityNodeEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ConnectivityNode entity =
        assignToEndIsoCode(event.getConnectivityNodeId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindConnectivityNode(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllConnectivityNode(entity);
  }

  /*
   * @param	event UnAssignToEndIsoCodeFromConnectivityNodeEvent
   */
  @EventHandler(payloadType = UnAssignToEndIsoCodeFromConnectivityNodeEvent.class)
  public void handle(UnAssignToEndIsoCodeFromConnectivityNodeEvent event) {
    LOGGER.info("handling UnAssignToEndIsoCodeFromConnectivityNodeEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ConnectivityNode entity = unAssignToEndIsoCode(event.getConnectivityNodeId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindConnectivityNode(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllConnectivityNode(entity);
  }

  /*
   * @param	event AssignToEndNameToConnectivityNodeEvent
   */
  @EventHandler(payloadType = AssignToEndNameToConnectivityNodeEvent.class)
  public void handle(AssignToEndNameToConnectivityNodeEvent event) {
    LOGGER.info("handling AssignToEndNameToConnectivityNodeEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ConnectivityNode entity = assignToEndName(event.getConnectivityNodeId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindConnectivityNode(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllConnectivityNode(entity);
  }

  /*
   * @param	event UnAssignToEndNameFromConnectivityNodeEvent
   */
  @EventHandler(payloadType = UnAssignToEndNameFromConnectivityNodeEvent.class)
  public void handle(UnAssignToEndNameFromConnectivityNodeEvent event) {
    LOGGER.info("handling UnAssignToEndNameFromConnectivityNodeEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ConnectivityNode entity = unAssignToEndName(event.getConnectivityNodeId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindConnectivityNode(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllConnectivityNode(entity);
  }

  /*
   * @param	event AssignToEndNameTsoToConnectivityNodeEvent
   */
  @EventHandler(payloadType = AssignToEndNameTsoToConnectivityNodeEvent.class)
  public void handle(AssignToEndNameTsoToConnectivityNodeEvent event) {
    LOGGER.info("handling AssignToEndNameTsoToConnectivityNodeEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ConnectivityNode entity =
        assignToEndNameTso(event.getConnectivityNodeId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindConnectivityNode(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllConnectivityNode(entity);
  }

  /*
   * @param	event UnAssignToEndNameTsoFromConnectivityNodeEvent
   */
  @EventHandler(payloadType = UnAssignToEndNameTsoFromConnectivityNodeEvent.class)
  public void handle(UnAssignToEndNameTsoFromConnectivityNodeEvent event) {
    LOGGER.info("handling UnAssignToEndNameTsoFromConnectivityNodeEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ConnectivityNode entity = unAssignToEndNameTso(event.getConnectivityNodeId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindConnectivityNode(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllConnectivityNode(entity);
  }

  /*
   * @param	event AssignConnectivityNodesToConnectivityNodeEvent
   */
  @EventHandler(payloadType = AssignConnectivityNodesToConnectivityNodeEvent.class)
  public void handle(AssignConnectivityNodesToConnectivityNodeEvent event) {
    LOGGER.info("handling AssignConnectivityNodesToConnectivityNodeEvent - " + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    ConnectivityNode entity =
        addToConnectivityNodes(event.getConnectivityNodeId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindConnectivityNode(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllConnectivityNode(entity);
  }

  /*
   * @param	event RemoveConnectivityNodesFromConnectivityNodeEvent
   */
  @EventHandler(payloadType = RemoveConnectivityNodesFromConnectivityNodeEvent.class)
  public void handle(RemoveConnectivityNodesFromConnectivityNodeEvent event) {
    LOGGER.info("handling RemoveConnectivityNodesFromConnectivityNodeEvent - " + event);

    ConnectivityNode entity =
        removeFromConnectivityNodes(event.getConnectivityNodeId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindConnectivityNode(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllConnectivityNode(entity);
  }

  /**
   * Method to retrieve the ConnectivityNode via an ConnectivityNodePrimaryKey.
   *
   * @param id Long
   * @return ConnectivityNode
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ConnectivityNode handle(FindConnectivityNodeQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getConnectivityNodeId());
  }

  /**
   * Method to retrieve a collection of all ConnectivityNodes
   *
   * @param query FindAllConnectivityNodeQuery
   * @return List<ConnectivityNode>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ConnectivityNode> handle(FindAllConnectivityNodeQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindConnectivityNode, but only if the id matches
   *
   * @param entity ConnectivityNode
   */
  protected void emitFindConnectivityNode(ConnectivityNode entity) {
    LOGGER.info("handling emitFindConnectivityNode");

    queryUpdateEmitter.emit(
        FindConnectivityNodeQuery.class,
        query -> query.getFilter().getConnectivityNodeId().equals(entity.getConnectivityNodeId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllConnectivityNode
   *
   * @param entity ConnectivityNode
   */
  protected void emitFindAllConnectivityNode(ConnectivityNode entity) {
    LOGGER.info("handling emitFindAllConnectivityNode");

    queryUpdateEmitter.emit(FindAllConnectivityNodeQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ConnectivityNodeProjector.class.getName());
}
