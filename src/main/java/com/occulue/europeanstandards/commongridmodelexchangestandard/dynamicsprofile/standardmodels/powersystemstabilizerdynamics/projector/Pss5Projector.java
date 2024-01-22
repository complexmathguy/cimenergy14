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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for Pss5 as outlined for the CQRS pattern. All event handling and query handling
 * related to Pss5 are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by Pss5Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("pss5")
@Component("pss5-projector")
public class Pss5Projector extends Pss5EntityProjector {

  // core constructor
  public Pss5Projector(Pss5Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreatePss5Event
   */
  @EventHandler(payloadType = CreatePss5Event.class)
  public void handle(CreatePss5Event event) {
    LOGGER.info("handling CreatePss5Event - " + event);
    Pss5 entity = new Pss5();
    entity.setPss5Id(event.getPss5Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss5(entity);
  }

  /*
   * @param	event UpdatePss5Event
   */
  @EventHandler(payloadType = UpdatePss5Event.class)
  public void handle(UpdatePss5Event event) {
    LOGGER.info("handling UpdatePss5Event - " + event);

    Pss5 entity = new Pss5();
    entity.setPss5Id(event.getPss5Id());
    entity.setCtw2(event.getCtw2());
    entity.setDeadband(event.getDeadband());
    entity.setIsfreq(event.getIsfreq());
    entity.setKf(event.getKf());
    entity.setKpe(event.getKpe());
    entity.setKpss(event.getKpss());
    entity.setPmm(event.getPmm());
    entity.setTl1(event.getTl1());
    entity.setTl2(event.getTl2());
    entity.setTl3(event.getTl3());
    entity.setTl4(event.getTl4());
    entity.setTpe(event.getTpe());
    entity.setTw1(event.getTw1());
    entity.setTw2(event.getTw2());
    entity.setVadat(event.getVadat());
    entity.setVsmn(event.getVsmn());
    entity.setVsmx(event.getVsmx());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss5(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss5(entity);
  }

  /*
   * @param	event DeletePss5Event
   */
  @EventHandler(payloadType = DeletePss5Event.class)
  public void handle(DeletePss5Event event) {
    LOGGER.info("handling DeletePss5Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    Pss5 entity = delete(event.getPss5Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss5(entity);
  }

  /*
   * @param	event AssignCtw2ToPss5Event
   */
  @EventHandler(payloadType = AssignCtw2ToPss5Event.class)
  public void handle(AssignCtw2ToPss5Event event) {
    LOGGER.info("handling AssignCtw2ToPss5Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss5 entity = assignCtw2(event.getPss5Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss5(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss5(entity);
  }

  /*
   * @param	event UnAssignCtw2FromPss5Event
   */
  @EventHandler(payloadType = UnAssignCtw2FromPss5Event.class)
  public void handle(UnAssignCtw2FromPss5Event event) {
    LOGGER.info("handling UnAssignCtw2FromPss5Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss5 entity = unAssignCtw2(event.getPss5Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss5(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss5(entity);
  }

  /*
   * @param	event AssignDeadbandToPss5Event
   */
  @EventHandler(payloadType = AssignDeadbandToPss5Event.class)
  public void handle(AssignDeadbandToPss5Event event) {
    LOGGER.info("handling AssignDeadbandToPss5Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss5 entity = assignDeadband(event.getPss5Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss5(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss5(entity);
  }

  /*
   * @param	event UnAssignDeadbandFromPss5Event
   */
  @EventHandler(payloadType = UnAssignDeadbandFromPss5Event.class)
  public void handle(UnAssignDeadbandFromPss5Event event) {
    LOGGER.info("handling UnAssignDeadbandFromPss5Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss5 entity = unAssignDeadband(event.getPss5Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss5(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss5(entity);
  }

  /*
   * @param	event AssignIsfreqToPss5Event
   */
  @EventHandler(payloadType = AssignIsfreqToPss5Event.class)
  public void handle(AssignIsfreqToPss5Event event) {
    LOGGER.info("handling AssignIsfreqToPss5Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss5 entity = assignIsfreq(event.getPss5Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss5(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss5(entity);
  }

  /*
   * @param	event UnAssignIsfreqFromPss5Event
   */
  @EventHandler(payloadType = UnAssignIsfreqFromPss5Event.class)
  public void handle(UnAssignIsfreqFromPss5Event event) {
    LOGGER.info("handling UnAssignIsfreqFromPss5Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss5 entity = unAssignIsfreq(event.getPss5Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss5(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss5(entity);
  }

  /*
   * @param	event AssignKfToPss5Event
   */
  @EventHandler(payloadType = AssignKfToPss5Event.class)
  public void handle(AssignKfToPss5Event event) {
    LOGGER.info("handling AssignKfToPss5Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss5 entity = assignKf(event.getPss5Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss5(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss5(entity);
  }

  /*
   * @param	event UnAssignKfFromPss5Event
   */
  @EventHandler(payloadType = UnAssignKfFromPss5Event.class)
  public void handle(UnAssignKfFromPss5Event event) {
    LOGGER.info("handling UnAssignKfFromPss5Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss5 entity = unAssignKf(event.getPss5Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss5(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss5(entity);
  }

  /*
   * @param	event AssignKpeToPss5Event
   */
  @EventHandler(payloadType = AssignKpeToPss5Event.class)
  public void handle(AssignKpeToPss5Event event) {
    LOGGER.info("handling AssignKpeToPss5Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss5 entity = assignKpe(event.getPss5Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss5(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss5(entity);
  }

  /*
   * @param	event UnAssignKpeFromPss5Event
   */
  @EventHandler(payloadType = UnAssignKpeFromPss5Event.class)
  public void handle(UnAssignKpeFromPss5Event event) {
    LOGGER.info("handling UnAssignKpeFromPss5Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss5 entity = unAssignKpe(event.getPss5Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss5(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss5(entity);
  }

  /*
   * @param	event AssignKpssToPss5Event
   */
  @EventHandler(payloadType = AssignKpssToPss5Event.class)
  public void handle(AssignKpssToPss5Event event) {
    LOGGER.info("handling AssignKpssToPss5Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss5 entity = assignKpss(event.getPss5Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss5(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss5(entity);
  }

  /*
   * @param	event UnAssignKpssFromPss5Event
   */
  @EventHandler(payloadType = UnAssignKpssFromPss5Event.class)
  public void handle(UnAssignKpssFromPss5Event event) {
    LOGGER.info("handling UnAssignKpssFromPss5Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss5 entity = unAssignKpss(event.getPss5Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss5(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss5(entity);
  }

  /*
   * @param	event AssignPmmToPss5Event
   */
  @EventHandler(payloadType = AssignPmmToPss5Event.class)
  public void handle(AssignPmmToPss5Event event) {
    LOGGER.info("handling AssignPmmToPss5Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss5 entity = assignPmm(event.getPss5Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss5(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss5(entity);
  }

  /*
   * @param	event UnAssignPmmFromPss5Event
   */
  @EventHandler(payloadType = UnAssignPmmFromPss5Event.class)
  public void handle(UnAssignPmmFromPss5Event event) {
    LOGGER.info("handling UnAssignPmmFromPss5Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss5 entity = unAssignPmm(event.getPss5Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss5(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss5(entity);
  }

  /*
   * @param	event AssignTl1ToPss5Event
   */
  @EventHandler(payloadType = AssignTl1ToPss5Event.class)
  public void handle(AssignTl1ToPss5Event event) {
    LOGGER.info("handling AssignTl1ToPss5Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss5 entity = assignTl1(event.getPss5Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss5(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss5(entity);
  }

  /*
   * @param	event UnAssignTl1FromPss5Event
   */
  @EventHandler(payloadType = UnAssignTl1FromPss5Event.class)
  public void handle(UnAssignTl1FromPss5Event event) {
    LOGGER.info("handling UnAssignTl1FromPss5Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss5 entity = unAssignTl1(event.getPss5Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss5(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss5(entity);
  }

  /*
   * @param	event AssignTl2ToPss5Event
   */
  @EventHandler(payloadType = AssignTl2ToPss5Event.class)
  public void handle(AssignTl2ToPss5Event event) {
    LOGGER.info("handling AssignTl2ToPss5Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss5 entity = assignTl2(event.getPss5Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss5(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss5(entity);
  }

  /*
   * @param	event UnAssignTl2FromPss5Event
   */
  @EventHandler(payloadType = UnAssignTl2FromPss5Event.class)
  public void handle(UnAssignTl2FromPss5Event event) {
    LOGGER.info("handling UnAssignTl2FromPss5Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss5 entity = unAssignTl2(event.getPss5Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss5(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss5(entity);
  }

  /*
   * @param	event AssignTl3ToPss5Event
   */
  @EventHandler(payloadType = AssignTl3ToPss5Event.class)
  public void handle(AssignTl3ToPss5Event event) {
    LOGGER.info("handling AssignTl3ToPss5Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss5 entity = assignTl3(event.getPss5Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss5(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss5(entity);
  }

  /*
   * @param	event UnAssignTl3FromPss5Event
   */
  @EventHandler(payloadType = UnAssignTl3FromPss5Event.class)
  public void handle(UnAssignTl3FromPss5Event event) {
    LOGGER.info("handling UnAssignTl3FromPss5Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss5 entity = unAssignTl3(event.getPss5Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss5(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss5(entity);
  }

  /*
   * @param	event AssignTl4ToPss5Event
   */
  @EventHandler(payloadType = AssignTl4ToPss5Event.class)
  public void handle(AssignTl4ToPss5Event event) {
    LOGGER.info("handling AssignTl4ToPss5Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss5 entity = assignTl4(event.getPss5Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss5(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss5(entity);
  }

  /*
   * @param	event UnAssignTl4FromPss5Event
   */
  @EventHandler(payloadType = UnAssignTl4FromPss5Event.class)
  public void handle(UnAssignTl4FromPss5Event event) {
    LOGGER.info("handling UnAssignTl4FromPss5Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss5 entity = unAssignTl4(event.getPss5Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss5(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss5(entity);
  }

  /*
   * @param	event AssignTpeToPss5Event
   */
  @EventHandler(payloadType = AssignTpeToPss5Event.class)
  public void handle(AssignTpeToPss5Event event) {
    LOGGER.info("handling AssignTpeToPss5Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss5 entity = assignTpe(event.getPss5Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss5(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss5(entity);
  }

  /*
   * @param	event UnAssignTpeFromPss5Event
   */
  @EventHandler(payloadType = UnAssignTpeFromPss5Event.class)
  public void handle(UnAssignTpeFromPss5Event event) {
    LOGGER.info("handling UnAssignTpeFromPss5Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss5 entity = unAssignTpe(event.getPss5Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss5(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss5(entity);
  }

  /*
   * @param	event AssignTw1ToPss5Event
   */
  @EventHandler(payloadType = AssignTw1ToPss5Event.class)
  public void handle(AssignTw1ToPss5Event event) {
    LOGGER.info("handling AssignTw1ToPss5Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss5 entity = assignTw1(event.getPss5Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss5(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss5(entity);
  }

  /*
   * @param	event UnAssignTw1FromPss5Event
   */
  @EventHandler(payloadType = UnAssignTw1FromPss5Event.class)
  public void handle(UnAssignTw1FromPss5Event event) {
    LOGGER.info("handling UnAssignTw1FromPss5Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss5 entity = unAssignTw1(event.getPss5Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss5(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss5(entity);
  }

  /*
   * @param	event AssignTw2ToPss5Event
   */
  @EventHandler(payloadType = AssignTw2ToPss5Event.class)
  public void handle(AssignTw2ToPss5Event event) {
    LOGGER.info("handling AssignTw2ToPss5Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss5 entity = assignTw2(event.getPss5Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss5(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss5(entity);
  }

  /*
   * @param	event UnAssignTw2FromPss5Event
   */
  @EventHandler(payloadType = UnAssignTw2FromPss5Event.class)
  public void handle(UnAssignTw2FromPss5Event event) {
    LOGGER.info("handling UnAssignTw2FromPss5Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss5 entity = unAssignTw2(event.getPss5Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss5(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss5(entity);
  }

  /*
   * @param	event AssignVadatToPss5Event
   */
  @EventHandler(payloadType = AssignVadatToPss5Event.class)
  public void handle(AssignVadatToPss5Event event) {
    LOGGER.info("handling AssignVadatToPss5Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss5 entity = assignVadat(event.getPss5Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss5(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss5(entity);
  }

  /*
   * @param	event UnAssignVadatFromPss5Event
   */
  @EventHandler(payloadType = UnAssignVadatFromPss5Event.class)
  public void handle(UnAssignVadatFromPss5Event event) {
    LOGGER.info("handling UnAssignVadatFromPss5Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss5 entity = unAssignVadat(event.getPss5Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss5(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss5(entity);
  }

  /*
   * @param	event AssignVsmnToPss5Event
   */
  @EventHandler(payloadType = AssignVsmnToPss5Event.class)
  public void handle(AssignVsmnToPss5Event event) {
    LOGGER.info("handling AssignVsmnToPss5Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss5 entity = assignVsmn(event.getPss5Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss5(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss5(entity);
  }

  /*
   * @param	event UnAssignVsmnFromPss5Event
   */
  @EventHandler(payloadType = UnAssignVsmnFromPss5Event.class)
  public void handle(UnAssignVsmnFromPss5Event event) {
    LOGGER.info("handling UnAssignVsmnFromPss5Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss5 entity = unAssignVsmn(event.getPss5Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss5(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss5(entity);
  }

  /*
   * @param	event AssignVsmxToPss5Event
   */
  @EventHandler(payloadType = AssignVsmxToPss5Event.class)
  public void handle(AssignVsmxToPss5Event event) {
    LOGGER.info("handling AssignVsmxToPss5Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Pss5 entity = assignVsmx(event.getPss5Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss5(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss5(entity);
  }

  /*
   * @param	event UnAssignVsmxFromPss5Event
   */
  @EventHandler(payloadType = UnAssignVsmxFromPss5Event.class)
  public void handle(UnAssignVsmxFromPss5Event event) {
    LOGGER.info("handling UnAssignVsmxFromPss5Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Pss5 entity = unAssignVsmx(event.getPss5Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPss5(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPss5(entity);
  }

  /**
   * Method to retrieve the Pss5 via an Pss5PrimaryKey.
   *
   * @param id Long
   * @return Pss5
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public Pss5 handle(FindPss5Query query) throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getPss5Id());
  }

  /**
   * Method to retrieve a collection of all Pss5s
   *
   * @param query FindAllPss5Query
   * @return List<Pss5>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<Pss5> handle(FindAllPss5Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindPss5, but only if the id matches
   *
   * @param entity Pss5
   */
  protected void emitFindPss5(Pss5 entity) {
    LOGGER.info("handling emitFindPss5");

    queryUpdateEmitter.emit(
        FindPss5Query.class,
        query -> query.getFilter().getPss5Id().equals(entity.getPss5Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllPss5
   *
   * @param entity Pss5
   */
  protected void emitFindAllPss5(Pss5 entity) {
    LOGGER.info("handling emitFindAllPss5");

    queryUpdateEmitter.emit(FindAllPss5Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(Pss5Projector.class.getName());
}
