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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.validator.*;
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
 * SetPoint business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of SetPoint related services in the case of a SetPoint business
 *       related service failing.
 *   <li>Exposes a simpler, uniform SetPoint interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill SetPoint business related
 *       services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class SetPointBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public SetPointBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * SetPoint Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return SetPointBusinessDelegate
   */
  public static SetPointBusinessDelegate getSetPointInstance() {
    return (new SetPointBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createSetPoint(CreateSetPointCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getSetPointId() == null) command.setSetPointId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      SetPointValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateSetPointCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateSetPointCommand of SetPoint is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create SetPoint - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateSetPointCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateSetPoint(UpdateSetPointCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      SetPointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateSetPointCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save SetPoint - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteSetPointCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteSetPointCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SetPointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteSetPointCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete SetPoint using Id = " + command.getSetPointId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the SetPoint via SetPointFetchOneSummary
   *
   * @param summary SetPointFetchOneSummary
   * @return SetPointFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public SetPoint getSetPoint(SetPointFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("SetPointFetchOneSummary arg cannot be null");

    SetPoint entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      SetPointValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a SetPoint
      // --------------------------------------
      CompletableFuture<SetPoint> futureEntity =
          queryGateway.query(
              new FindSetPointQuery(new LoadSetPointFilter(summary.getSetPointId())),
              ResponseTypes.instanceOf(SetPoint.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate SetPoint with id " + summary.getSetPointId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all SetPoints
   *
   * @return List<SetPoint>
   * @exception ProcessingException Thrown if any problems
   */
  public List<SetPoint> getAllSetPoint() throws ProcessingException {
    List<SetPoint> list = null;

    try {
      CompletableFuture<List<SetPoint>> futureList =
          queryGateway.query(
              new FindAllSetPointQuery(), ResponseTypes.multipleInstancesOf(SetPoint.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all SetPoint";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign NormalValue on SetPoint
   *
   * @param command AssignNormalValueToSetPointCommand
   * @exception ProcessingException
   */
  public void assignNormalValue(AssignNormalValueToSetPointCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSetPointId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    SetPointBusinessDelegate parentDelegate = SetPointBusinessDelegate.getSetPointInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SetPointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Simple_Float using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign NormalValue on SetPoint
   *
   * @param command UnAssignNormalValueFromSetPointCommand
   * @exception ProcessingException
   */
  public void unAssignNormalValue(UnAssignNormalValueFromSetPointCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SetPointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign NormalValue on SetPoint";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Value on SetPoint
   *
   * @param command AssignValueToSetPointCommand
   * @exception ProcessingException
   */
  public void assignValue(AssignValueToSetPointCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSetPointId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    SetPointBusinessDelegate parentDelegate = SetPointBusinessDelegate.getSetPointInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SetPointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Simple_Float using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Value on SetPoint
   *
   * @param command UnAssignValueFromSetPointCommand
   * @exception ProcessingException
   */
  public void unAssignValue(UnAssignValueFromSetPointCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SetPointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Value on SetPoint";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return SetPoint
   */
  private SetPoint load(UUID id) throws ProcessingException {
    setPoint =
        SetPointBusinessDelegate.getSetPointInstance().getSetPoint(new SetPointFetchOneSummary(id));
    return setPoint;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private SetPoint setPoint = null;
  private static final Logger LOGGER = Logger.getLogger(SetPointBusinessDelegate.class.getName());
}
