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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.validator.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryUpdateEmitter;

/**
 * PhaseTapChangerAsymmetrical business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of PhaseTapChangerAsymmetrical related services in the case of a
 *       PhaseTapChangerAsymmetrical business related service failing.
 *   <li>Exposes a simpler, uniform PhaseTapChangerAsymmetrical interface to the business tier,
 *       making it easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill
 *       PhaseTapChangerAsymmetrical business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class PhaseTapChangerAsymmetricalBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public PhaseTapChangerAsymmetricalBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * PhaseTapChangerAsymmetrical Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return PhaseTapChangerAsymmetricalBusinessDelegate
   */
  public static PhaseTapChangerAsymmetricalBusinessDelegate
      getPhaseTapChangerAsymmetricalInstance() {
    return (new PhaseTapChangerAsymmetricalBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createPhaseTapChangerAsymmetrical(
      CreatePhaseTapChangerAsymmetricalCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getPhaseTapChangerAsymmetricalId() == null)
        command.setPhaseTapChangerAsymmetricalId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      PhaseTapChangerAsymmetricalValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreatePhaseTapChangerAsymmetricalCommand - by convention the future return value
      // for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreatePhaseTapChangerAsymmetricalCommand of PhaseTapChangerAsymmetrical is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create PhaseTapChangerAsymmetrical - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdatePhaseTapChangerAsymmetricalCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updatePhaseTapChangerAsymmetrical(
      UpdatePhaseTapChangerAsymmetricalCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      PhaseTapChangerAsymmetricalValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdatePhaseTapChangerAsymmetricalCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save PhaseTapChangerAsymmetrical - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeletePhaseTapChangerAsymmetricalCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeletePhaseTapChangerAsymmetricalCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PhaseTapChangerAsymmetricalValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeletePhaseTapChangerAsymmetricalCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete PhaseTapChangerAsymmetrical using Id = "
              + command.getPhaseTapChangerAsymmetricalId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the PhaseTapChangerAsymmetrical via
   * PhaseTapChangerAsymmetricalFetchOneSummary
   *
   * @param summary PhaseTapChangerAsymmetricalFetchOneSummary
   * @return PhaseTapChangerAsymmetricalFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public PhaseTapChangerAsymmetrical getPhaseTapChangerAsymmetrical(
      PhaseTapChangerAsymmetricalFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "PhaseTapChangerAsymmetricalFetchOneSummary arg cannot be null");

    PhaseTapChangerAsymmetrical entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      PhaseTapChangerAsymmetricalValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a PhaseTapChangerAsymmetrical
      // --------------------------------------
      CompletableFuture<PhaseTapChangerAsymmetrical> futureEntity =
          queryGateway.query(
              new FindPhaseTapChangerAsymmetricalQuery(
                  new LoadPhaseTapChangerAsymmetricalFilter(
                      summary.getPhaseTapChangerAsymmetricalId())),
              ResponseTypes.instanceOf(PhaseTapChangerAsymmetrical.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate PhaseTapChangerAsymmetrical with id "
              + summary.getPhaseTapChangerAsymmetricalId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all PhaseTapChangerAsymmetricals
   *
   * @return List<PhaseTapChangerAsymmetrical>
   * @exception ProcessingException Thrown if any problems
   */
  public List<PhaseTapChangerAsymmetrical> getAllPhaseTapChangerAsymmetrical()
      throws ProcessingException {
    List<PhaseTapChangerAsymmetrical> list = null;

    try {
      CompletableFuture<List<PhaseTapChangerAsymmetrical>> futureList =
          queryGateway.query(
              new FindAllPhaseTapChangerAsymmetricalQuery(),
              ResponseTypes.multipleInstancesOf(PhaseTapChangerAsymmetrical.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all PhaseTapChangerAsymmetrical";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign WindingConnectionAngle on PhaseTapChangerAsymmetrical
   *
   * @param command AssignWindingConnectionAngleToPhaseTapChangerAsymmetricalCommand
   * @exception ProcessingException
   */
  public void assignWindingConnectionAngle(
      AssignWindingConnectionAngleToPhaseTapChangerAsymmetricalCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPhaseTapChangerAsymmetricalId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .AngleDegreesBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .AngleDegreesBusinessDelegate.getAngleDegreesInstance();
    PhaseTapChangerAsymmetricalBusinessDelegate parentDelegate =
        PhaseTapChangerAsymmetricalBusinessDelegate.getPhaseTapChangerAsymmetricalInstance();
    UUID childId = command.getAssignment().getAngleDegreesId();
    AngleDegrees child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PhaseTapChangerAsymmetricalValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get AngleDegrees using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign WindingConnectionAngle on PhaseTapChangerAsymmetrical
   *
   * @param command UnAssignWindingConnectionAngleFromPhaseTapChangerAsymmetricalCommand
   * @exception ProcessingException
   */
  public void unAssignWindingConnectionAngle(
      UnAssignWindingConnectionAngleFromPhaseTapChangerAsymmetricalCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PhaseTapChangerAsymmetricalValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign WindingConnectionAngle on PhaseTapChangerAsymmetrical";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return PhaseTapChangerAsymmetrical
   */
  private PhaseTapChangerAsymmetrical load(UUID id) throws ProcessingException {
    phaseTapChangerAsymmetrical =
        PhaseTapChangerAsymmetricalBusinessDelegate.getPhaseTapChangerAsymmetricalInstance()
            .getPhaseTapChangerAsymmetrical(new PhaseTapChangerAsymmetricalFetchOneSummary(id));
    return phaseTapChangerAsymmetrical;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private PhaseTapChangerAsymmetrical phaseTapChangerAsymmetrical = null;
  private static final Logger LOGGER =
      Logger.getLogger(PhaseTapChangerAsymmetricalBusinessDelegate.class.getName());
}
