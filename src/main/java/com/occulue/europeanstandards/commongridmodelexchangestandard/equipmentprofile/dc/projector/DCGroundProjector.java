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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for DCGround as outlined for the CQRS pattern. All event handling and query handling
 * related to DCGround are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by DCGroundAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("dCGround")
@Component("dCGround-projector")
public class DCGroundProjector extends DCGroundEntityProjector {

  // core constructor
  public DCGroundProjector(DCGroundRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateDCGroundEvent
   */
  @EventHandler(payloadType = CreateDCGroundEvent.class)
  public void handle(CreateDCGroundEvent event) {
    LOGGER.info("handling CreateDCGroundEvent - " + event);
    DCGround entity = new DCGround();
    entity.setDCGroundId(event.getDCGroundId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDCGround(entity);
  }

  /*
   * @param	event UpdateDCGroundEvent
   */
  @EventHandler(payloadType = UpdateDCGroundEvent.class)
  public void handle(UpdateDCGroundEvent event) {
    LOGGER.info("handling UpdateDCGroundEvent - " + event);

    DCGround entity = new DCGround();
    entity.setDCGroundId(event.getDCGroundId());
    entity.setInductance(event.getInductance());
    entity.setR(event.getR());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDCGround(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDCGround(entity);
  }

  /*
   * @param	event DeleteDCGroundEvent
   */
  @EventHandler(payloadType = DeleteDCGroundEvent.class)
  public void handle(DeleteDCGroundEvent event) {
    LOGGER.info("handling DeleteDCGroundEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    DCGround entity = delete(event.getDCGroundId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDCGround(entity);
  }

  /*
   * @param	event AssignInductanceToDCGroundEvent
   */
  @EventHandler(payloadType = AssignInductanceToDCGroundEvent.class)
  public void handle(AssignInductanceToDCGroundEvent event) {
    LOGGER.info("handling AssignInductanceToDCGroundEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DCGround entity = assignInductance(event.getDCGroundId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDCGround(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDCGround(entity);
  }

  /*
   * @param	event UnAssignInductanceFromDCGroundEvent
   */
  @EventHandler(payloadType = UnAssignInductanceFromDCGroundEvent.class)
  public void handle(UnAssignInductanceFromDCGroundEvent event) {
    LOGGER.info("handling UnAssignInductanceFromDCGroundEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DCGround entity = unAssignInductance(event.getDCGroundId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDCGround(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDCGround(entity);
  }

  /*
   * @param	event AssignRToDCGroundEvent
   */
  @EventHandler(payloadType = AssignRToDCGroundEvent.class)
  public void handle(AssignRToDCGroundEvent event) {
    LOGGER.info("handling AssignRToDCGroundEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DCGround entity = assignR(event.getDCGroundId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDCGround(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDCGround(entity);
  }

  /*
   * @param	event UnAssignRFromDCGroundEvent
   */
  @EventHandler(payloadType = UnAssignRFromDCGroundEvent.class)
  public void handle(UnAssignRFromDCGroundEvent event) {
    LOGGER.info("handling UnAssignRFromDCGroundEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DCGround entity = unAssignR(event.getDCGroundId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDCGround(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDCGround(entity);
  }

  /**
   * Method to retrieve the DCGround via an DCGroundPrimaryKey.
   *
   * @param id Long
   * @return DCGround
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public DCGround handle(FindDCGroundQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getDCGroundId());
  }

  /**
   * Method to retrieve a collection of all DCGrounds
   *
   * @param query FindAllDCGroundQuery
   * @return List<DCGround>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<DCGround> handle(FindAllDCGroundQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindDCGround, but only if the id matches
   *
   * @param entity DCGround
   */
  protected void emitFindDCGround(DCGround entity) {
    LOGGER.info("handling emitFindDCGround");

    queryUpdateEmitter.emit(
        FindDCGroundQuery.class,
        query -> query.getFilter().getDCGroundId().equals(entity.getDCGroundId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllDCGround
   *
   * @param entity DCGround
   */
  protected void emitFindAllDCGround(DCGround entity) {
    LOGGER.info("handling emitFindAllDCGround");

    queryUpdateEmitter.emit(FindAllDCGroundQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(DCGroundProjector.class.getName());
}
