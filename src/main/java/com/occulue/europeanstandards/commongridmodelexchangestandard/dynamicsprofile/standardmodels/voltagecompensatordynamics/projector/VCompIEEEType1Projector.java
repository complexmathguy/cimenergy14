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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.voltagecompensatordynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.voltagecompensatordynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for VCompIEEEType1 as outlined for the CQRS pattern. All event handling and query
 * handling related to VCompIEEEType1 are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by VCompIEEEType1Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("vCompIEEEType1")
@Component("vCompIEEEType1-projector")
public class VCompIEEEType1Projector extends VCompIEEEType1EntityProjector {

  // core constructor
  public VCompIEEEType1Projector(
      VCompIEEEType1Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateVCompIEEEType1Event
   */
  @EventHandler(payloadType = CreateVCompIEEEType1Event.class)
  public void handle(CreateVCompIEEEType1Event event) {
    LOGGER.info("handling CreateVCompIEEEType1Event - " + event);
    VCompIEEEType1 entity = new VCompIEEEType1();
    entity.setVCompIEEEType1Id(event.getVCompIEEEType1Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllVCompIEEEType1(entity);
  }

  /*
   * @param	event UpdateVCompIEEEType1Event
   */
  @EventHandler(payloadType = UpdateVCompIEEEType1Event.class)
  public void handle(UpdateVCompIEEEType1Event event) {
    LOGGER.info("handling UpdateVCompIEEEType1Event - " + event);

    VCompIEEEType1 entity = new VCompIEEEType1();
    entity.setVCompIEEEType1Id(event.getVCompIEEEType1Id());
    entity.setRc(event.getRc());
    entity.setTr(event.getTr());
    entity.setXc(event.getXc());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindVCompIEEEType1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllVCompIEEEType1(entity);
  }

  /*
   * @param	event DeleteVCompIEEEType1Event
   */
  @EventHandler(payloadType = DeleteVCompIEEEType1Event.class)
  public void handle(DeleteVCompIEEEType1Event event) {
    LOGGER.info("handling DeleteVCompIEEEType1Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    VCompIEEEType1 entity = delete(event.getVCompIEEEType1Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllVCompIEEEType1(entity);
  }

  /*
   * @param	event AssignRcToVCompIEEEType1Event
   */
  @EventHandler(payloadType = AssignRcToVCompIEEEType1Event.class)
  public void handle(AssignRcToVCompIEEEType1Event event) {
    LOGGER.info("handling AssignRcToVCompIEEEType1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    VCompIEEEType1 entity = assignRc(event.getVCompIEEEType1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindVCompIEEEType1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllVCompIEEEType1(entity);
  }

  /*
   * @param	event UnAssignRcFromVCompIEEEType1Event
   */
  @EventHandler(payloadType = UnAssignRcFromVCompIEEEType1Event.class)
  public void handle(UnAssignRcFromVCompIEEEType1Event event) {
    LOGGER.info("handling UnAssignRcFromVCompIEEEType1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    VCompIEEEType1 entity = unAssignRc(event.getVCompIEEEType1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindVCompIEEEType1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllVCompIEEEType1(entity);
  }

  /*
   * @param	event AssignTrToVCompIEEEType1Event
   */
  @EventHandler(payloadType = AssignTrToVCompIEEEType1Event.class)
  public void handle(AssignTrToVCompIEEEType1Event event) {
    LOGGER.info("handling AssignTrToVCompIEEEType1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    VCompIEEEType1 entity = assignTr(event.getVCompIEEEType1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindVCompIEEEType1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllVCompIEEEType1(entity);
  }

  /*
   * @param	event UnAssignTrFromVCompIEEEType1Event
   */
  @EventHandler(payloadType = UnAssignTrFromVCompIEEEType1Event.class)
  public void handle(UnAssignTrFromVCompIEEEType1Event event) {
    LOGGER.info("handling UnAssignTrFromVCompIEEEType1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    VCompIEEEType1 entity = unAssignTr(event.getVCompIEEEType1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindVCompIEEEType1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllVCompIEEEType1(entity);
  }

  /*
   * @param	event AssignXcToVCompIEEEType1Event
   */
  @EventHandler(payloadType = AssignXcToVCompIEEEType1Event.class)
  public void handle(AssignXcToVCompIEEEType1Event event) {
    LOGGER.info("handling AssignXcToVCompIEEEType1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    VCompIEEEType1 entity = assignXc(event.getVCompIEEEType1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindVCompIEEEType1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllVCompIEEEType1(entity);
  }

  /*
   * @param	event UnAssignXcFromVCompIEEEType1Event
   */
  @EventHandler(payloadType = UnAssignXcFromVCompIEEEType1Event.class)
  public void handle(UnAssignXcFromVCompIEEEType1Event event) {
    LOGGER.info("handling UnAssignXcFromVCompIEEEType1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    VCompIEEEType1 entity = unAssignXc(event.getVCompIEEEType1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindVCompIEEEType1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllVCompIEEEType1(entity);
  }

  /**
   * Method to retrieve the VCompIEEEType1 via an VCompIEEEType1PrimaryKey.
   *
   * @param id Long
   * @return VCompIEEEType1
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public VCompIEEEType1 handle(FindVCompIEEEType1Query query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getVCompIEEEType1Id());
  }

  /**
   * Method to retrieve a collection of all VCompIEEEType1s
   *
   * @param query FindAllVCompIEEEType1Query
   * @return List<VCompIEEEType1>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<VCompIEEEType1> handle(FindAllVCompIEEEType1Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindVCompIEEEType1, but only if the id matches
   *
   * @param entity VCompIEEEType1
   */
  protected void emitFindVCompIEEEType1(VCompIEEEType1 entity) {
    LOGGER.info("handling emitFindVCompIEEEType1");

    queryUpdateEmitter.emit(
        FindVCompIEEEType1Query.class,
        query -> query.getFilter().getVCompIEEEType1Id().equals(entity.getVCompIEEEType1Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllVCompIEEEType1
   *
   * @param entity VCompIEEEType1
   */
  protected void emitFindAllVCompIEEEType1(VCompIEEEType1 entity) {
    LOGGER.info("handling emitFindAllVCompIEEEType1");

    queryUpdateEmitter.emit(FindAllVCompIEEEType1Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(VCompIEEEType1Projector.class.getName());
}
